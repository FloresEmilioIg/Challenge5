# 🏬 Challenge5 — Spring Boot Order Management API

## Made by Emilio Flores Licea

## Version 1.1.1

## 📌 Overview

**Challenge5** is a Spring Boot REST API for managing customers, products, and orders.  
It demonstrates clean architecture using **Spring Boot**, **JPA (Hibernate)**, and **PostgreSQL**, with integrated **Swagger/OpenAPI** documentation for easy testing and exploration.

This system includes endpoints for:
- Managing **Customers**
- Managing **Products**
- Managing **Orders**

and uses environment-specific **Spring profiles** for **development**, **testing**, and **production** environments.

---

## 🚀 Features

- RESTful endpoints for CRUD operations on customers, products, and orders  
- Environment profile management (`dev`, `test`, `prod`)  
- PostgreSQL integration  
- Validation via `jakarta.validation`  
- OpenAPI 3 (Swagger UI) for interactive documentation  
- Modular structure following the MVC pattern  

---

## 🛠️ Project Structure
 ### com.example.Challenge5/

  ### Controller/ REST controllers (Customer, Product, Order)
  
  ### DTO/ Data Transfer Objects (CreateOrder)
  
  ### Model/ JPA entities
  
  ### Repos/ Spring Data repositories
  
  ### Visual/ Service layer (OrderService)
  
  ### Challenge5Application | Main Spring Boot entry point
  
  ---

## ⚙️ Prerequisites

Ensure you have the following installed:

- **Java 17+**
- **Maven 3.8+**
- **PostgreSQL 14+**
- **Git**
- (Optional) **Docker** if you want to containerize the application

---

## 🧩 Configuration

### 🧾 Environment Variables

This project uses environment variables for secure configuration.  
You can define them in your operating system or an `.env` file.

| Variable          | Description                          | Example Value                          |
|--------------------|--------------------------------------|----------------------------------------|
| `DB_URL`          | Database JDBC URL                    | `jdbc:postgresql://localhost:5432/storedb?charSet=UTF8` |
| `DB_USERNAME`     | Database username                    | `postgres`                             |
| `DB_PASSWORD`     | Database password                    | `1234`                                 |
| `SPRING_PROFILES_ACTIVE` | Active Spring Boot profile       | `dev`, `test`, or `prod`               |

---

## 🌱 Spring Boot Profiles

Spring profiles allow the application to adapt its behavior depending on the environment.

### 🔹 Available Profiles

| Profile | Description |
|----------|--------------|
| `dev`    | For local development. Enables verbose logging and automatic schema updates. |
| `test`   | Used for testing with an isolated database. Often uses `H2` or a testing container. |
| `prod`   | For deployment in production. Enforces stricter settings, disables debug logs, and connects to the live database. |

---

### ⚙️ Profile Configuration Files

Each profile has its own YAML configuration file located in `src/main/resources/`:

application.yml

application-dev.yml

application-test.yml

application-prod.yml

---
🔄 Switching Between Profiles

There are three ways to activate a specific profile:

1. Using environment variable

export SPRING_PROFILES_ACTIVE=dev

2. Using Maven command

mvn spring-boot:run -Dspring-boot.run.profiles=prod

3. Using application.yml

In the base application.yml, set:

spring:

  profiles:
    active: dev

---

▶️ Running the Application
🖥️ Local Execution

1. Clone the repository:

git clone https://github.com/FloresEmilioIg/Challenge5.git

2. Configure your .env file or export environment variables:

  
  
3. Run with Maven:

  mvn spring-boot:run

4. Access Swagger UI:

  http://localhost:8080/swagger-ui/index.html

