# Exercícios de Orientação a Objetos

Projeto Maven com implementação dos exercícios de Orientação a Objetos em Java.

## Estrutura do Projeto

```
exercicios-maven/
├── pom.xml
└── src/
    └── main/
        └── java/
            ├── exercicio1/     (Campeonato de Futebol)
            │   ├── Campeonato.java
            │   ├── Time.java
            │   ├── Jogador.java
            │   ├── Partida.java
            │   ├── Cartao.java
            │   └── Main1.java
            └── exercicio2/     (Loja Virtual)
                ├── Loja.java
                ├── Produto.java
                ├── Categoria.java
                ├── Cliente.java
                ├── Pedido.java
                ├── ItemPedido.java
                └── Main2.java
```

## Como Compilar

```bash
cd exercicios-maven
javac -d target/classes src/main/java/exercicio1/*.java src/main/java/exercicio2/*.java
```

## Como Executar

### Exercício 1 - Campeonato de Futebol

```bash
java -cp target/classes exercicio1.Main1
```

### Exercício 2 - Loja Virtual

```bash
java -cp target/classes exercicio2.Main2
```

## Requisitos

- Java 11+
- Maven 3.6+ (opcional, compilação manual funciona com javac)

## Características

- ✅ Sem programação funcional (sem streams, lambdas)
- ✅ Uso de loops tradicionais (for, while)
- ✅ Estrutura Maven padrão
- ✅ Pacotes separados para cada exercício
- ✅ Dois Main classes para testar cada exercício
