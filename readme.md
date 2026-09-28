# JavaExam — Library Management System

An educational project for a library management system built on **Spring Boot**. It implements user registration and authentication, as well as the management of books, authors, publishers, and categories, and the checkout of books to readers.

The project was developed as part of a course on Java and the Spring Framework (2023) to demonstrate working with web applications built on Spring Boot: MVC architecture, ORM, user authentication, and server-side page rendering.

## Technology Stack

- **Java** + **Spring Boot**
- **Spring Security** — authentication and authorization
- **Spring Data JPA** — working with a database
- **Thymeleaf** — server-side page rendering
- **MariaDB** — database
- **Maven** — project compilation

## Features

- User registration and login (with roles)
- Viewing, adding, and editing books
- Managing authors, publishers, topics, and book categories
- Checking out books to readers (library card tracking)

## Project structure

```
src/main/java/com/example/
├── controllers/     # HTTP-controllers (Book, Author, Account, Home)
├── models/          # Entities: Book, Author, AppUser, Press, Theme, Category, UCard, Librarian
├── repositories/     # Spring Data JPA repositories
├── services/          # Buisness-logic (AppUserService)
└── securingweb/       # Configuration of Spring Security

src/main/resources/
├── templates/          # Thymeleaf-page templates
├── static/css/          # Styles
└── application.properties
```

## How to start project

### Requirements
- JDK 17+
- Maven (or use the built-in `mvnw`)
- MariaDB (running locally)

### Steps

1. Create database in MariaDB:
```sql
CREATE DATABASE libraryEx;
```

2. Configure connection to DB in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mariadb://localhost/libraryEx
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Start project:
```bash
./mvnw spring-boot:run
```

4. Open in browser: `http://localhost:8080`
