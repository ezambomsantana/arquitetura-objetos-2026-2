## Sistema de Projetos

Implemente uma API REST para gerenciamento de usuários e projetos.

### Entidades:

- Pessoa
  
-- id

-- nome

-- cpf

- Projeto
-- id
-- nome
-- descricao

- Departamento
-- id
-- nome

Também adicione o login para que apenas um usuários cadastrado possa adicionar pessoas e projetos, e também relacionar pessoas e projetos, usando a autenticação com token JWT.

### Requisitos:

- Uma pessoa pode participar de vários projetos e um projeto pode ter vários usuários.
- Um projeto sempre pertence a um departamento.
- O departamento pode ter vários projetos.
- Implemente as operações CRUD para ambas as entidades.
- Permita adicionar e remover usuários de projetos.
- Na criação do projeto, indique a qual departamento esse projeto pertence.
- Utilize Spring Data JPA.
- Adicione validações básicas (ex: nome e CPF obrigatório).
- Implemente tratamento de erros global com respostas padronizadas (JSON com mensagem, status, timestamp, etc.).
