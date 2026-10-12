# Turismo - API REST

Nossa API está praticamente pronta, mas vamos deixa-la com
as melhores práticas REST, vamos fazer 3 mudanças, que são:

1. Mudar a autenticação para usar tokens JWT.
2. Usar DTOs tanto para request para response.
3. Melhorar a validação e o tratamento de erros.

## Autenticação com JWT

### Fluxo de Autenticação

```
1. Registrar usuário (POST /usuarios)
   └─ Email e senha são salvos no banco

2. Fazer login (POST /login)
   ├─ Envia email e senha
   └─ Recebe um JWT token

3. Usar token em requisições autenticadas
   ├─ Adiciona header: Authorization: Bearer <token>
   └─ API valida o token e processa a requisição
```

### Passo a Passo: Migração de Basic Auth para JWT

#### 1. Dependências Maven

As seguintes dependências foram adicionadas ao `pom.xml`. Utilizamos a versão **0.12.3** do JJWT, que possui uma API mais recente:

```xml
<!-- JJWT - JSON Web Token Library (versão 0.12.3) -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.3</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.3</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.3</version>
    <scope>runtime</scope>
</dependency>
```

#### 2. Serviço JWT (JwtService.java)

Responsável por gerar e validar tokens JWT. Utiliza a biblioteca JJWT 0.12.3:

```java
@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration:3600000}") // 1 hora em ms
    private long jwtExpiration;

    // Gera um novo token JWT
    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Extrai o email (subject) do token
    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // Valida se o token é válido (assinatura e expiração)
    public boolean isTokenValid(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSigningKey())
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(
            Base64.getEncoder().encodeToString(secretKey.getBytes())
        );
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
```

#### 3. Filtro JWT (JwtAuthenticationFilter.java)

Intercepta requisições e valida o token JWT:

```java
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                   FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        // Extrai o token do header Authorization: Bearer <token>
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            username = jwtService.extractUsername(token);
        }

        // Valida o token e configura a autenticação
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtService.isTokenValid(token)) {
                UserDetails userDetails = usuarioService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
```

#### 4. Configuração de Segurança (SecurityConfig.java)

Atualizada para remover Basic Auth e adicionar o filtro JWT. O `JwtAuthenticationFilter` é injetado como parâmetro do método para evitar dependência circular:

```java
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/usuarios").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers("/swagger-ui.html", "/h2-console/**",
                                "/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**",
                                "/webjars/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

#### 5. Endpoint de Login (UsuarioController.java)

Novo endpoint para realizar login e obter o token:

```java
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
    try {
        UserDetails userDetails = usuarioService.loadUserByUsername(loginRequest.getEmail());

        if (!passwordEncoder.matches(loginRequest.getSenha(), userDetails.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }

        String token = jwtService.generateToken(loginRequest.getEmail());
        return ResponseEntity.ok(new LoginResponse(token));
    } catch (UsernameNotFoundException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado");
    }
}
```

#### 6. DTOs de Login

**LoginRequest.java**
```java
public class LoginRequest {
    private String email;
    private String senha;
    // getters e setters
}
```

**LoginResponse.java**
```java
public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }
    // getter
}
```

#### 7. Configuração (application.properties)

Adicione as seguintes propriedades:

```properties
# JWT Configuration
jwt.secret=sua-chave-secreta-muito-segura-aqui-minimo-32-caracteres
jwt.expiration=3600000
```

**⚠️ IMPORTANTE:**
- A chave secreta (`jwt.secret`) deve ter **no mínimo 32 caracteres**
- Utilize uma chave forte em produção
- **Nunca** commite a chave real no repositório, use variáveis de ambiente


## Usar DTOs para requisições e respostas


## Melhorar a validação e o tratamento  de erros
