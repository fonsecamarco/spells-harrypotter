# 🪄 Harry Potter Spells API

API RESTful desenvolvida em **Java 21** e **Spring Boot 4.1.1** para gerenciamento e consulta de feitiços do universo de Harry Potter. A aplicação conta com persistência em banco de dados **H2**, validação de dados de entrada com **DTOs** e carga inicial automatizada via `data.sql`.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas
* **Linguagem:** Java 21
* **Framework:** Spring Boot 4.1.1
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** H2 Database (em memória)
* **Validação:** Spring Boot Starter Validation (Bean Validation)
* **Gerenciador de Dependências:** Maven
* **Utilitários:** Lombok & Java Records

---

## 📌 Arquitetura & Boas Práticas Aplicadas
* **Arquitetura em Camadas (Separation of Concerns):**
  * `Controller`: Mapeamento de endpoints e protocolos HTTP.
  * `Service`: Camada de regras de negócio e conversão entre DTOs e Entidades.
  * `Repository`: Abstração de acesso aos dados com `JpaRepository`.
  * `Model/Entity`: Mapeamento Objeto-Relacional (ORM) com `@Entity` e chave primária com `@GeneratedValue(strategy = GenerationType.IDENTITY)`.
  * `DTO (Data Transfer Objects)`: Uso de **Java Records** (`SpellPostRequestBody` e `SpellPutRequestBody`) isolando a camada externa das entidades de banco.
* **Validação de Entrada:** Uso do Bean Validation (`@NotBlank`, `@Size`, `@NotNull`, `@Valid`) garantindo que dados inconsistentes retornem HTTP `400 Bad Request`.
* **Tratamento de Erros e Respostas HTTP Semânticas:**
  * `200 OK` para consultas e atualizações bem-sucedidas.
  * `201 CREATED` para criações (`POST`).
  * `204 NO CONTENT` para remoções (`DELETE`).
  * `400 BAD REQUEST` para falhas de validação nos DTOs.
  * `404 NOT FOUND` via `ResponseStatusException` quando um feitiço não existe.

---

## 🚀 Endpoints da API

| Método | Endpoint | Descrição | Corpo da Requisição (Body) |
| :--- | :--- | :--- | :--- |
| `GET` | `/spells` | Retorna a lista de todos os feitiços | N/A |
| `GET` | `/spells/{id}` | Busca um feitiço específico por ID | N/A |
| `POST` | `/spells` | Cadastra um novo feitiço no banco | `SpellPostRequestBody` (JSON) |
| `PUT` | `/spells` | Atualiza um feitiço existente | `SpellPutRequestBody` (JSON com ID) |
| `DELETE` | `/spells/{id}` | Remove um feitiço por ID | N/A |

---

## 💻 Como executar o projeto localmente

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/SEU-USUARIO/spells-harrypotter.git](https://github.com/SEU-USUARIO/spells-harrypotter.git)