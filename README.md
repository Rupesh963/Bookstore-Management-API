# 📚 RESTful Bookstore API

A RESTful backend API built with **Spring Boot** for managing books and authors — featuring full CRUD operations, dynamic filtering, pagination, sorting, validation, centralized error handling, and interactive Swagger documentation.

> Built as part of the **Elevate Labs Internship Project Phase**.

---

## ✨ Features

- 🔁 **Full CRUD** for both `Book` and `Author` resources
- 🔗 **One-to-many relationship** between Author and Book (via JPA)
- 🔍 **Dynamic filtering** — search books by title or author
- 📄 **Pagination & sorting** on book listings
- ✅ **Request validation** with clean, structured error responses
- ⚠️ **Centralized exception handling** (`404`, `400` with descriptive JSON)
- 📑 **Swagger UI** — auto-generated interactive API docs
- 🗄️ **H2 in-memory database** — zero setup required to run

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 21 |
| Framework | Spring Boot 4.1 |
| Data Access | Spring Data JPA / Hibernate |
| Database | H2 (in-memory) |
| Validation | Jakarta Bean Validation |
| Docs | springdoc-openapi (Swagger UI) |
| Build Tool | Maven |
| Boilerplate | Lombok |

---

## 🚀 Getting Started

### Prerequisites
- JDK 17+
- Maven 3.8+

### Run locally

```bash
git clone https://github.com/<your-username>/bookstore-api.git
cd bookstore-api
mvn spring-boot:run
```

The app starts on **`http://localhost:8080`**

### Key URLs

| Resource | URL |
|---|---|
| Swagger UI | `http://localhost:8080/swagger-ui.html` |
| OpenAPI JSON | `http://localhost:8080/v3/api-docs` |
| H2 Console | `http://localhost:8080/h2-console` |
| Books API | `http://localhost:8080/api/books` |
| Authors API | `http://localhost:8080/api/authors` |

**H2 Console login:** JDBC URL `jdbc:h2:mem:bookstoredb`, user `sa`, blank password.

> ⚠️ H2 is in-memory — all data resets when the app restarts.

---

## 📡 API Endpoints

### Authors

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/authors` | Get all authors |
| `GET` | `/api/authors/{id}` | Get author by id |
| `POST` | `/api/authors` | Create a new author |
| `PUT` | `/api/authors/{id}` | Update an author |
| `DELETE` | `/api/authors/{id}` | Delete an author |

### Books

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/books` | Get all books (paginated) |
| `GET` | `/api/books?title=hobbit` | Filter books by title |
| `GET` | `/api/books?authorId=1` | Filter books by author |
| `GET` | `/api/books?page=0&size=5&sort=price,desc` | Paginate & sort |
| `GET` | `/api/books/{id}` | Get book by id |
| `POST` | `/api/books` | Create a new book |
| `PUT` | `/api/books/{id}` | Update a book |
| `DELETE` | `/api/books/{id}` | Delete a book |

---

## 📥 Example Requests

**Create an author**
```http
POST /api/authors
Content-Type: application/json

{
  "name": "J.R.R. Tolkien",
  "email": "tolkien@example.com",
  "nationality": "British"
}
```

**Create a book**
```http
POST /api/books
Content-Type: application/json

{
  "title": "The Hobbit",
  "price": 499.0,
  "publicationYear": 1937,
  "authorId": 1
}
```

**Filter + sort books**
```http
GET /api/books?title=hobbit&sort=price,desc&page=0&size=5
```

---

## ❌ Error Handling

The API returns clean, structured JSON errors instead of raw stack traces.

**Resource not found (404):**
```json
{
  "timestamp": "2026-07-17T18:12:24.372261",
  "status": 404,
  "error": "Not Found",
  "message": "Book not found with id: 999"
}
```

**Validation failure (400):**
```json
{
  "timestamp": "2026-07-17T18:12:24.372261",
  "status": 400,
  "error": "Validation Failed",
  "messages": {
    "authorId": "authorId is required"
  }
}
```

---

## 🧪 Testing

Import `Bookstore-API.postman_collection.json` into Postman — it includes pre-built requests for every endpoint, covering successful calls, filtering, pagination, sorting, and error cases.

Or use **Swagger UI** at `/swagger-ui.html` to try every endpoint directly from the browser.

---

## 📂 Project Structure

```
src/main/java/com/projectlabs/bookstore_api/
├── BookstoreApiApplication.java   # main entry point
├── entity/                        # Book, Author JPA entities
├── repository/                    # Spring Data JPA repositories + Specifications
├── controller/                    # REST controllers
├── dto/                           # request DTOs (BookRequest, AuthorRequest)
├── exception/                     # custom exception + global handler
```

---

## 🔮 Future Improvements

- Switch to a persistent database (MySQL/PostgreSQL) for production use
- Add authentication & authorization (Spring Security + JWT)
- Add unit and integration tests (JUnit + Mockito)
- Add a frontend client (React) for a full-stack demo

---

## 👤 Author

**Rupesh Kumar**
