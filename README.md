# API de Funcionários

API REST desenvolvida em Java com Spring Boot para gerenciamento de funcionários.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Postman

## Funcionalidades

A API possui as operações básicas de CRUD:

- Cadastrar funcionário
- Listar funcionários
- Buscar funcionário por ID
- Atualizar funcionário
- Remover funcionário

## Endpoints

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/funcionarios` | Cadastra um funcionário |
| GET | `/funcionarios` | Lista todos os funcionários |
| GET | `/funcionarios/{id}` | Busca um funcionário pelo ID |
| PUT | `/funcionarios/{id}` | Atualiza um funcionário |
| DELETE | `/funcionarios/{id}` | Remove um funcionário |

## Exemplo de requisição

POST `/funcionarios`

```json
{
  "nome": "João",
  "cpf": "12345678900",
  "cargo": "Desenvolvedor",
  "salario": 5000.0
}
