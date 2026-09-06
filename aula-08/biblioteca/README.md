# Aula 08 - 08/09/2026

## Adicionar swagger

O swagger é uma documentação da API gerada automaticamente.

Além de ser uma documentação ela também ajuda nos testes da API.

```
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>3.1.0</version>
</dependency>
```

## DTOs para rotas que não retornam dados do modelo

Algumas rotas podem retornar dados que não são diretamente do modelo,
por exemplo, podemos ter uma rota que retorna quantos livros cada editora possui.

Para ter esse tipo de dado, é usado um padrão de projeto chamado DTO (Data Transfer Object),
nele criamos uma classe que representa esse tipo de dado. Por exemplo:

``` java
public class EditoraLivroDTO {
    private String nomeEditora;
    private Integer numeroLivros;
    
    //gets e sets
}
```

## Tratamento de erros

No Java, temos um tratamento de erros parecido com o python,
com o `try/catch` ao invés do `try/except` e o `throw` ao invés do `raise`.

As classes princiapais de exceções sãs a `Exception` e a `RuntimeException`.
Vamos usar principalmente a RuntimeException, com ela podemos criar exceções próprias,
como a `LivroNotFoundException`. Com ela, podemos fazer o tratamento dessa exceção para
retornar uma mensagem para o usuário e o código de erro correto.


```java
    @ExceptionHandler(LivroNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO erro(LivroNotFoundException re) {
        ErrorResponseDTO error = new ErrorResponseDTO();
        error.setMessage(re.getMessage());
        error.setCode(HttpStatus.NOT_FOUND.value());
        error.setDate(LocalDateTime.now());
        return error;
    }
```

