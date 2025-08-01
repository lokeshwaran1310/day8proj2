
# HelpDeskORM - Ticket Management System

## Overview

HelpDeskORM is a Spring Boot-based RESTful web application designed to manage user-submitted tickets, track issues using tags, and maintain user associations. It follows the **Database-First approach** using JPA (Hibernate ORM) and integrates with **PostgreSQL**.

This project was developed as part of a training program to practice backend development with real-world data modeling and service design.

---

## Features

- Manage Users, Tickets, and Tags
- Relationships:
  - One-to-Many: User → Tickets
  - Many-to-Many: Ticket ↔ Tags
- RESTful APIs to:
  - Create and retrieve tickets
  - List tickets by user and associated tags

---

## Technologies Used

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Lombok** (optional)
- **VS Code / IntelliJ**

---

## Project Structure

```
src
├── main
│   ├── java
│   │   └── com.example.day8proj2
│   │       ├── controller
│   │       ├── domain
│   │       ├── repository
│   │       └── service
│   └── resources
│       └── application.properties
└── test
```

---

## API Endpoints

| Method | Endpoint               | Description                  |
|--------|------------------------|------------------------------|
| GET    | `/tickets`             | Get all tickets              |
| GET    | `/tickets/{id}`        | Get ticket by ID             |
| POST   | `/tickets`             | Create a new ticket          |
| GET    | `/tickets/sample`      | Get formatted ticket output  |

---

## Sample Response (GET `/tickets/sample`)

```json
[
  {
    "title": "Login Issue",
    "user": "Alice",
    "tags": ["Bug", "UI"]
  },
  {
    "title": "Page Crash",
    "user": "Bob",
    "tags": ["Backend"]
  }
]
```

---

## How to Run

### Prerequisites

- Java 21
- PostgreSQL (running on port 5432)
- Maven

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/helpdeskorm.git
   cd helpdeskorm
   ```

2. Configure `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
   spring.datasource.username=your_user
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

3. Build and run the project:
   ```bash
   mvn spring-boot:run
   ```

4. Test the APIs using Postman or browser at:
   ```
   http://localhost:8080/tickets/sample
   ```

---

## Database Schema

- **tusers**: `userid`, `fullname`, `email`
- **tickets**: `ticketid`, `title`, `userid`
- **tags**: `tagid`, `name`
- **tickettags**: Join table for Ticket–Tag relationship

---

## Dummy Data (PostgreSQL)

```sql
-- Insert Users
INSERT INTO tusers (fullname, email) VALUES ('Alice', 'alice@example.com');
INSERT INTO tusers (fullname, email) VALUES ('Bob', 'bob@example.com');

-- Insert Tags
INSERT INTO tags (name) VALUES ('Bug'), ('UI'), ('Backend');

-- Insert Tickets
INSERT INTO tickets (title, userid) VALUES ('Login Issue', 1);
INSERT INTO tickets (title, userid) VALUES ('Page Crash', 2);

-- Insert into TicketTags
INSERT INTO tickettags (ticketid, tagid) VALUES (1, 1), (1, 2), (2, 3);
```

---

## Author

- **Name:** Lokeshwaran M
- **Email:** lokeshwaran.m@epssw.com

---

## License

This project is for educational/training purposes and is not licensed for production use.
