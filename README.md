
```markdown
# 📝 Task API - Java 24 + Spring Boot + PostgreSQL + Swagger

Uma API simples e moderna para gerenciamento de tarefas, construída com **Java 24**, **Spring Boot**, **PostgreSQL**, e documentação interativa via **Swagger**.  
Utiliza arquitetura em camadas e recursos como **DTOs com `record`**, **Lombok**, **MapStruct**, e **Spring Data JPA**.

---

## 🌐 Swagger UI

📄 Acesse a documentação interativa em:

```

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

````

Você pode testar todos os endpoints diretamente por lá, sem precisar de Postman ou Insomnia.

---

## 📁 Estrutura do Projeto

com.API.tasks/
├── business/
│   ├── dtos/
│   │   ├── TaskRequestDTO.java
│   │   └── TaskResponseDTO.java
│   ├── mapstruct/
│   │   ├── TaskMapper.java
│   │   └── TaskUpdater.java
│   └── TaskService.java
├── controller/
│   └── TaskController.java
├── infrastructure/
│   ├── entitys/
│   │   └── TaskEntity.java
│   └── repository/
│       └── TaskRepo.java
````

---

## 🧠 Entidades e DTOs

### 🔹 `TaskEntity`

```java
@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;
    String status;
    OffsetDateTime createdAt;
}
```

### 🔹 `TaskRequestDTO` (record)

```java
public record TaskRequestDTO(String description, String status) {}
```

### 🔹 `TaskResponseDTO` (record)

```java
public record TaskResponseDTO(String description, String status) {}
```

---

## 🚀 Endpoints da API

> 🔍 Todos os endpoints podem ser testados via Swagger em `http://localhost:8080/swagger-ui.html`.

### 📌 `POST /task` – Criar nova tarefa

**Corpo da requisição:**

```json
{
  "description": "Estudar Java",
  "status": "Pendente"
}
```

<img width="361" height="373" alt="image" src="https://github.com/user-attachments/assets/c4135d61-d295-43bd-bb98-da853a7451ca" />


---

### 📌 `PUT /task?id={id}` – Marcar como concluída

```http
PUT /task?id=1
```

<img width="394" height="281" alt="image" src="https://github.com/user-attachments/assets/de736085-2e92-463e-978b-e6df2b199b37" />

---

### 📌 `PUT /task/{id}` – Atualizar tarefa

**Corpo da requisição:**

```json
{
  "description": "Estudar Spring",
  "status": "complete"
}
```

```http
PUT /task/1
```

<img width="353" height="276" alt="image" src="https://github.com/user-attachments/assets/16f77919-185d-4465-976f-5e23cad29831" />

---

### 📌 `GET /task?description={substring}` – Buscar por descrição

```http
GET /task?description=Estudar
```

<img width="437" height="440" alt="image" src="https://github.com/user-attachments/assets/39de496d-4510-43bf-94c9-908138f6b2de" />

---

### 📌 `GET /list` – Listar todas as tarefas

```json
[
  {
    "description": "Estudar Java",
    "status": "Pendente"
  },
  {
    "description": "Fazer exercícios",
    "status": "Concluído"
  }
]
```

<img width="452" height="530" alt="image" src="https://github.com/user-attachments/assets/b16277cb-deff-42ea-9289-073aaa4db8e9" />

---

## 🛠️ Como rodar localmente

### ✅ Requisitos

* Java **24**
* PostgreSQL
* Maven 3.8+

---

### 🗄️ Banco de dados

1. Crie o banco:

```sql
CREATE DATABASE task_db;
```

2. Configure o `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/task_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update


### ▶️ Executando

git clone https://github.com/seu-usuario/task-api.git
cd task-api
./mvnw spring-boot:run
```

Acesse:
📄 `http://localhost:8080/swagger-ui.html`

---


