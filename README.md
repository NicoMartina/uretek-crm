# Uretek CRM: Customer Relationship Management System

---

## 🚀 Project Overview

A comprehensive Customer Relationship Management (CRM) system built to streamline lead tracking, client management, and logistics operations for Uretek Argentina. This application provides a centralized platform for managing the complete customer lifecycle, from initial contact through ongoing relationship management.

## 🛠️ Technology Stack

- **Core Language:** Java 17+
- **Framework:** Spring Boot 3.x
- **Persistence:** Spring Data JPA (Hibernate)
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Architecture:** RESTful API with layered MVC pattern

---

## 📋 Key Features

### 1. **Lead Management**
- Capture and track potential customers from multiple sources
- Lead status tracking (New, Contacted, Qualified, Converted)
- Assignment of leads to sales representatives
- Lead scoring and prioritization

### 2. **Client Management**
- Comprehensive client profile management
- Contact information storage and updates
- Client interaction history tracking
- Document and note attachment capabilities

### 3. **Logistics Operations**
- Service request tracking
- Appointment scheduling and management
- Job status monitoring
- Resource allocation

### 4. **Data Management**
- RESTful API endpoints for all CRUD operations
- Data validation and business rule enforcement
- Transaction management for data integrity
- Query optimization for performance

---

## 🏗️ Architecture

The application follows a clean **layered architecture** based on the MVC pattern:

```
┌─────────────────────────────────────┐
│   Controller Layer (REST API)       │  ← HTTP Requests/Responses
├─────────────────────────────────────┤
│   Service Layer (Business Logic)    │  ← Validation, Rules, Calculations
├─────────────────────────────────────┤
│   Repository Layer (Data Access)    │  ← JPA/Hibernate Queries
├─────────────────────────────────────┤
│   Model Layer (Entities)             │  ← Database Tables
└─────────────────────────────────────┘
```

### Core Components:

- **Controllers:** Handle HTTP requests and route to appropriate services
- **Services:** Implement business logic and coordinate between layers
- **Repositories:** Extend JpaRepository for database operations
- **Models/Entities:** JPA entities representing database schema

---

## 🚦 Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.x
- PostgreSQL database
- Git

### Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/NicoMartina/uretek-crm.git
   cd uretek-crm
   ```

2. **Configure the database:**
   
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/uretek_crm
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. **Build the project:**
   ```bash
   ./mvnw clean install
   ```

4. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080`

---

## 🌐 API Endpoints

### Lead Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/leads` | Get all leads |
| GET | `/api/v1/leads/{id}` | Get lead by ID |
| POST | `/api/v1/leads` | Create new lead |
| PUT | `/api/v1/leads/{id}` | Update lead |
| DELETE | `/api/v1/leads/{id}` | Delete lead |

### Client Management

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/v1/clients` | Get all clients |
| GET | `/api/v1/clients/{id}` | Get client by ID |
| POST | `/api/v1/clients` | Create new client |
| PUT | `/api/v1/clients/{id}` | Update client |
| DELETE | `/api/v1/clients/{id}` | Delete client |

### Example Request (Create Lead)

```json
POST /api/v1/leads
Content-Type: application/json

{
  "name": "Juan Pérez",
  "email": "juan.perez@example.com",
  "phone": "+54 11 1234-5678",
  "company": "Empresa SA",
  "status": "NEW",
  "source": "Website Contact Form"
}
```

---

## 💡 Technical Highlights

- **RESTful Design:** Clean, resource-based API following REST principles
- **Data Validation:** Input validation using Spring Validation annotations
- **Exception Handling:** Centralized error handling with custom exceptions
- **Transaction Management:** `@Transactional` annotations for data consistency
- **Repository Pattern:** Abstracted data access layer using Spring Data JPA
- **Separation of Concerns:** Clear boundaries between presentation, business, and data layers

---

## 📂 Project Structure

```
src/
├── main/
│   ├── java/com/uretek/crm/
│   │   ├── controller/     # REST API controllers
│   │   ├── service/        # Business logic
│   │   ├── repository/     # Data access layer
│   │   ├── model/          # JPA entities
│   │   ├── dto/            # Data transfer objects
│   │   └── exception/      # Custom exceptions
│   └── resources/
│       └── application.properties
└── test/                   # Unit and integration tests
```

---

## 🔮 Future Enhancements

- Email notification system
- Advanced search and filtering
- Dashboard with analytics
- Export functionality (CSV, PDF)
- Role-based access control
- Integration with external services

---

## 👨‍💻 Author

**Nicolás Martina**

Developed as part of a structured learning program focused on enterprise Java backend development.

---

## 📝 License

This project was created for educational purposes.
