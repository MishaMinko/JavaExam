# JavaExam — Library Management System

Навчальний проєкт системи обліку бібліотеки на **Spring Boot**. Реалізує реєстрацію та авторизацію користувачів, облік книг, авторів, видавництв і категорій, а також видачу книг читачам.

Проєкт розроблено в межах навчального курсу з Java та Spring Framework (2023 рік) як демонстрація роботи з веб-застосунками на Spring Boot: MVC-архітектура, ORM, автентифікація користувачів та серверний рендеринг сторінок.

## Стек технологій

- **Java** + **Spring Boot**
- **Spring Security** — автентифікація та авторизація
- **Spring Data JPA** — робота з базою даних
- **Thymeleaf** — серверний рендеринг сторінок
- **MariaDB** — база даних
- **Maven** — збірка проєкту

## Функціонал

- Реєстрація та вхід користувачів (з ролями)
- Перегляд, додавання та редагування книг
- Управління авторами, видавництвами, темами та категоріями книг
- Видача книг читачам (облік бібліотечних карток)

## Структура проєкту

```
src/main/java/com/example/
├── controllers/     # HTTP-контролери (Book, Author, Account, Home)
├── models/          # Сутності: Book, Author, AppUser, Press, Theme, Category, UCard, Librarian
├── repositories/     # Spring Data JPA репозиторії
├── services/          # Бізнес-логіка (AppUserService)
└── securingweb/       # Конфігурація Spring Security

src/main/resources/
├── templates/          # Thymeleaf-шаблони сторінок
├── static/css/          # Стилі
└── application.properties
```

## Запуск проєкту

### Вимоги
- JDK 17+
- Maven (або використати вбудований `mvnw`)
- MariaDB (запущена локально)

### Кроки

1. Створіть базу даних у MariaDB:
```sql
CREATE DATABASE libraryEx;
```

2. Налаштуйте підключення до БД у `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mariadb://localhost/libraryEx
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Запустити проєкт:
```bash
./mvnw spring-boot:run
```

4. Відкрити у браузері: `http://localhost:8080`