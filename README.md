# SpringBoot-APIRest-ProductManagement

## 📦 Description

This project is a RESTful API built with **Spring Boot**, designed for managing **products**, **categories**, **users**, and **orders**. It includes role-based access control using **Spring Security**, and interacts with a **MySQL** database.

## 🚀 Technologies Used

- **Java 17**
    
- **Spring Boot 3.x**
    
- **Spring Security**
    
- **Spring Data JPA (Hibernate)**
    
- **MySQL**
    
- **Bean Validation (Jakarta Validation API)**
    
- **Maven**
    

## 🔐 Roles and Permissions

The application defines two main roles:

- `ADMIN`: Full access to all resources and endpoints.
    
- `USER`:
    
    - Read-only access to **products** and **categories**.
        
    - Full **CRUD access to their own orders**.
        

Authentication is handled using **Basic Authentication**.

## 📁 Project Structure
```pgsql
src/
├── main/
│   ├── java/
│   │   └── com/example/productmanagement/
│   │       ├── config/
|   |       ├── controllers/
│   │       ├── dtos/
│   │           ├── requests/
│   │           └── responses/
│   │       ├── enums/
│   │       ├── exception/
│   │       ├── models/
│   │       ├── repository/
│   │       ├── services/
│   │       └── utils/
│   └── resources/
│       └── application.properties
├── pom.xml
└── README.md

```

## ⚙️ Configuring `application.properties`

To connect the application to your **MySQL database**, you must configure the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8080
```


✅ Replace `your_database_name`, `your_username`, and `your_password` with your actual MySQL credentials.

---

## 📌 Main Endpoints

### 👤 Users

- `POST /api/users`: Register new user (public access).
    
- `GET /api/users/{id}`: Get user by ID.
    
- `PUT /api/users/{id}`: Update user info.
    
- `DELETE /api/users/{id}`: Delete user.
    
- `GET /api/users`: List all users (**ADMIN only**).
    

### 📦 Products

- `GET /api/products`: Get all products.
    
- `GET /api/products/{id}`: Get product by ID.
    
- `POST /api/products`: Create product (**ADMIN only**).
    
- `PUT /api/products/{id}`: Update product (**ADMIN only**).
    
- `DELETE /api/products/{id}`: Delete product (**ADMIN only**).
    

### 🗂️ Categories

- `GET /api/categories`: Get all categories.
    
- `GET /api/categories/{id}`: Get category by ID.
    
- `POST /api/categories`: Create category (**ADMIN only**).
    
- `PUT /api/categories/{id}`: Update category (**ADMIN only**).
    
- `DELETE /api/categories/{id}`: Delete category (**ADMIN only**).
    

### 🧾 Orders

- `GET /api/orders`: Get orders of logged-in user.
    
- `GET /api/orders/{id}`: Get specific order.
    
- `POST /api/orders`: Create order.
    
- `PUT /api/orders/{id}`: Update order.
    
- `DELETE /api/orders/{id}`: Delete order.
    

---

## ✅ Validation and Error Handling

- Uses `@Valid`, `@NotBlank`, `@Positive`, `@Size`, etc. for input validation in DTOs.
    
- Custom error handling with `@ControllerAdvice` to return meaningful error messages in JSON format.
    

---

## ▶️ Running the Application

1. **Clone the repository:**
    
    `git clone https://github.com/Jesus24-Dev/SpringBoot-APIRest-ProductManagement.git cd SpringBoot-APIRest-ProductManagement`
    
2. **Build with Maven:**
    
    `mvn clean install`
    
3. **Run the application:**
    
    `mvn spring-boot:run`
    
4. **Access your API:**
    
    - Base URL: `http://localhost:8080`

---

## 🔐 Testing Authentication

When calling protected endpoints (anything except `/api/users` for registration):

- Use **Basic Auth** with a valid username and password.
    
- Make sure the user has the appropriate role (`ADMIN` or `USER`).
    

---

## 📜 License

This project is licensed under the MIT License.