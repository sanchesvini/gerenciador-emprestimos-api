# Sistema de Gerenciamento de Empréstimos de Livros

API RESTful em Spring Boot para gerenciar usuários e empréstimos de livros de uma biblioteca simples.

---

## Requisitos

Certifique-se de ter os seguintes itens instalados:

- Java 17
- Maven
- MySQL ou outro banco compatível
- Git
- IDE como IntelliJ IDEA ou VS Code

---

## Como rodar o projeto localmente

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/desafio2.git
cd seu-projeto
```

### 2. Configure o banco de dados

Edite o arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Compile e rode

```bash
./mvnw spring-boot:run
```

Ou:

```bash
mvn clean install
java -jar target/desafio2-0.0.1-SNAPSHOT.jar
```

---
### 3. Acessando a API

Após iniciar a aplicação, a API estará disponível por padrão em:

```bash
http://localhost:8080
```



## Tecnologias usadas

- Spring Boot
- Spring Data JPA
- MySQL (ou outro banco relacional)

---

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── desafio2/
│   │       └── desafio2/
│   │           ├── rest/
|   |               └── exceptions/
│   │           ├── services/
│   │           ├── entities/
│   │           ├── dtos/
│   │           └── repositories/
│   └── resources/
│       ├── application.properties
│       └── static/
└── test/
```

---

## Endpoints da API

### Livros

1. `GET /api/livros` - Listar todos os livros.  
2. `GET /api/livros/{id}` - Buscar livro por ID.  
3. `POST /api/livros` - Cadastrar novo livro.  
4. `PUT /api/livros/{id}` - Atualizar livro existente.  
5. `DELETE /api/livros/{id}` - Excluir livro por ID.  

### Usuários

1. `GET /api/usuarios` - Listar todos os usuários.  
2. `GET /api/usuarios/{id}` - Buscar usuário por ID.  
3. `POST /api/usuarios` - Cadastrar novo usuário.  
4. `PUT /api/usuarios/{id}` - Atualizar usuário existente.  
5. `DELETE /api/usuarios/{id}` - Excluir usuário por ID.
6. `GET /api/usuarios/{usuarioId}/livros-emprestados` - Lista os livros emprestados por um usuário.

### Empréstimo/Devolução de Livros

1. `POST /api/livros/{livroId}/emprestar/{usuarioId}` - Realizar o empréstimo de um livro.
2. `POST /api/livros/{livroId}/devolver` - Realizar a devolução de um livro.

---
