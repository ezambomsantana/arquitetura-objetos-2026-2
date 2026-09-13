# Aula 10 - Exercício 13/09

## Sistema de locação de equipamentos


### Implementar uma API REST com as seguintes entidades:

- Cliente: nome, e-mail, cpf e telefone.
- Equipamento: nome, categoria, valorDiaria e codigoPatrimonio e disponível.
- Locacao: id, dataInicio, dataFim, e uma relação com cliente e equipamento.


### Requisitos

- Todas as entidades devem possuir rotas para criar, listar, buscar por id, editar e excluir.
- A exclusão deve ser lógica, por meio do atributo deleted, com valor booleano. Nenhuma operação pode ser realizada sobre registros excluídos.
- Na criação de uma locação, o cliente deve ser informado no body da requisição, e o sistema deve selecionar automaticamente um equipamento ativo. 
Poode ser qualquer algoritmo, por exemplo, selecionar o primeiro equipamento disponível.
- Todos os campos em todas as entidades são obrigatórios.
- Todas as rotas devem ser autenticadas, com exceção da rota de listagem de equipamentos, que deve ser aberta.
