# Store - Sistema de E-Commerce

## Descrição
Este projeto é um sistema de e-commerce, que  permite o cadastro de produtos, clientes e a realização de compras, com validações e tratamento de erros para garantir a integridade dos dados.

---

## Funcionalidades
- **Cadastro de Produtos**:
    - Nome único.
    - Preço maior que 0.
    - Quantidade maior ou igual a 0.
- **Cadastro de Clientes**:
    - Nome.
    - CPF único e válido.
    - Email único e válido.
- **Realização de Compras**:
    - Identificação do cliente pelo CPF.
    - Atualização da quantidade de produtos no estoque.
    - Validação de produtos em falta.
    - Caso um produto esteja em falta, a compra não será realizada e o sistema retornará um erro 400 com a mensagem: `{"erro": "Produto em falta: [nome do produto]"}`.

## Tecnologias Utilizadas
- **Java 17**
- **Spring Boot**
- **Maven**
- **H2 Database**
- **JPA**
- **Jakarta Bean Validation**
- **Thunder Client** (para testes de API)

---

## Como Executar
1. Clone o repositório:
   ```bash
   git clone <https://github.com/GabriellyZup/store>
2. Navegue até o diretorio do projeto:
    ```bash
   cd ecommerce-api
3. Execute o projeto:
   ```bash
   mvn spring-boot:run

4. Acesse o banco de dados H2:
    - URL: http://localhost:8080/h2-console
    - JDBC URL: jdbc:h2:mem:testdb
    - Usuário: sa
    - Senha: (deixe em branco)

5. Utilize o Thunderclient (dentro do VSCode), ou equivalente para testes.

## Endpoints
### Produtos
- `GET /produto` - Retorna a lista de todos os produtos cadastrados.
- `POST /produto` - Cadastra um novo produto.
- - `PUT /produto/{nome}` - Atualiza dados de um produto.
- `DELETE /produto/{nome}` - Deleta um produto.

### Clientes
- `POST /cliente` - Cadastra um novo cliente.
- `GET /cliente/{cpf}` - Retorna os dados de um cliente específico pelo CPF.
- `PUT /cliente/{cpf}` - Atualiza dados de um cliente.
- `DELETE /cliente/{CPF}` - Deleta um produto.

### Compras
- `POST /compra` - Registra uma nova compra e atualiza a quantidade de produtos.

---

## Exemplos de Requisições

### Cadastro de Produtos
- Nome único (não pode ser repetido).
- Preço maior que 0.
- Quantidade maior ou igual a 0.
- Não será permitido cadastrar produtos com o mesmo nome.

### Cadastro de Clientes
- Nome.
- CPF único e válido.
- Email único e válido.
- Não será permitido cadastrar clientes com o mesmo CPF ou Email.

### Realização de Compras
- Identificação do cliente pelo CPF.
- Atualização da quantidade de produtos no estoque.
- Validação de produtos em falta:
    - Produtos com quantidade 0 não podem ser comprados.
    - Caso um produto esteja em falta, a compra não será realizada e o sistema retornará um erro 400 com a mensagem:

  ```json
      { "erro": "Produto em falta: [nome do produto]" }

---

## Endpoints

### **1. Produtos**


#### **POST /produto**
- Cadastra um novo produto.


- **Exemplo de Requisição**:
  ```json
  {
    "name": "Produto1",
    "price": 54.0,
    "quantity": 5
    }

- **Exemplo de Resposta**:
  ```json
  {
    "name": "Produto1",
    "price": 54.0,
    "quantity": 5
    }


#### **GET /produto**
- Retorna a lista de todos os produtos cadastrados.


- **Exemplo de Resposta**:
  ```json
  [
  {
    "name": "Produto1",
    "price": 54.0,
    "quantity": 5
  },
  {
    "name": "Produto2",
    "price": 54.0,
    "quantity": 2
  },
  {
    "name": "Produto3",
    "price": 54.0,
    "quantity": 2
  },
  {
    "name": "Produto4",
    "price": 54.0,
    "quantity": 3
  },
  {
    "name": "Produto5",
    "price": 54.0,
    "quantity": 0
  }
]

#### **GET /produto/{nome}**
- Retorna um unico produto cadastrado.


- **Exemplo de Resposta**:
  ```json
  {
    "name": "Produto1",
    "price": 54.0,
    "quantity": 5
  }

#### **PUT /produto/{nome}**
- Altera preço e quantidade de um produto cadastrado.


- **Exemplo de Requisição**:
  ```json
  {
    "name": "Produto1",
    "price": 54.0,
    "quantity": 0
}

- **Exemplo de Resposta**:
  ```json
  {
  "name": "Produto1",
  "price": 54.0,
  "quantity": 0
}


#### **DELETE /produto/{nome}**
- Exclui um produto.


- **Exemplo de Resposta**:
  ```json
  {
  "mensagem": "Produto deletado com sucesso."
   }

### **2. Clientes**

#### **POST /cliente**
- Cadastra um novo cliente.


- **Exemplo de Requisição**:
  ```json
  {
    "name": "cliente1 cliente",
    "cpf": "84361466033",
    "email": "cliente1@email.com"
  }

- **Exemplo de Resposta**:
  ```json
  {
    "name": "cliente1 cliente",
    "cpf": "84361466033",
    "email": "cliente1@email.com"
  }

#### **GET /cliente**
- Retorna a lista de todos os clientes cadastrados.


- **Exemplo de Resposta**:
  ```json
    {
    "name": "cliente1 cliente",
    "cpf": "84361466033",
    "email": "cliente1@email.com"
    }
    {
    "name": "cliente2 cliente",
    "cpf": "97001426040",
    "email": "cliente2@email.com"
    }
    {
    "name": "cliente3 cliente",
    "cpf": "22245208080",
    "email": "cliente3@email.com"
    }
    {
    "name": "cliente4 cliente",
    "cpf": "24344011040",
    "email": "cliente4@email.com"
    }
    {
    "name": "cliente5 cliente",
    "cpf": "69798136098",
    "email": "cliente5@email.com"
    }

#### **GET /cliente/{CPF}**
- Retorna um unico cliente cadastrado.


- **Exemplo de Resposta**:
  ```json
    {
    "name": "cliente1 cliente",
    "cpf": "84361466033",
    "email": "cliente1@email.com"
    }

#### **PUT /cliente/{CPF}**
- Altera nome e email de um cliente cadastrado.


- **Exemplo de Requisição**:
  ```json
  {
    "name": "altera cliente2 cliente",
    "cpf": "97001426040",
    "email": "cliente2@email.com"
  }

- **Exemplo de Resposta**:
  ```json
  {
    "name": "altera cliente2 cliente",
    "cpf": "97001426040",
    "email": "cliente2@email.com"
  }

#### **DELETE /cliente/{CPF}**
- Exclui um cliente.

- **Exemplo de Resposta**:
  ```json
  {
  "mensagem": "Cliente deletado com sucesso."
   }

### **2. Compras**

#### **POST /compra**
- Cadastra uma compra.


- **Exemplo de Requisição**:
  ```json
  {
    "cpf": "22245208080",
    "produtos": [
      {
        "nome": "Produto2"
      },
      {
        "nome": "Produto3"
      }
    ]
  }

- **Exemplo de Resposta**:
  ```json
  {
  "id": 1,
  "client": {
    "name": "cliente3 cliente",
    "cpf": "22245208080",
    "email": "cliente3@email.com"
  },
  "products": [
    {
      "name": "Produto2",
      "price": 54.0,
      "quantity": 4
    },
    {
      "name": "Produto3",
      "price": 54.0,
      "quantity": 4
    }
  ],
  "orderDate": "2025-02-02T00:52:14.2002043"
    }

- **Compra de produto sem estoque**:

- No caso de produtos sem estoque, a compra não é finalizada e o usuário recebe a mensagem:
    ```json
    Erro inesperado: Produtos indisponíveis: [Produto1]