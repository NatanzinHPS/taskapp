# Task App
Uma API REST simples para gerenciamento de tarefas desenvolvida com Spring Boot.

---

## Funcionalidades
- CRUD completo de tarefas (Criar, Listar, Atualizar, Deletar).  
- Campos da tarefa:
  - `id` (Long)  
  - `title` (String)  
  - `description` (String)  
  - `status` (TO_DO, IN_PROGRESS, DONE)  
  - `createdAt` (LocalDateTime)  
- Conversão automática Entity ↔ DTO com MapStruct.  
- Documentação da API via Swagger.  
- Banco H2 em memória para testes.

---

## Tecnologias
- Java 17  
- Spring Boot  
- Spring Data JPA  
- H2 Database  
- Lombok  
- MapStruct  
- Swagger / OpenAPI  

---

## 🔗 Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/tasks` | Lista todas as tarefas |
| GET | `/tasks/{id}` | Busca tarefa por ID |
| POST | `/tasks` | Cria nova tarefa |
| PUT | `/tasks/{id}` | Atualiza tarefa |
| DELETE | `/tasks/{id}` | Remove tarefa |

## 📝 Modelo de dados

### Task
```json
{
  "id": 1,
  "title": "Título da tarefa",
  "description": "Descrição da tarefa",
  "status": "TO_DO",
  "createdAt": "2025-01-01T10:00:00"
}
```
