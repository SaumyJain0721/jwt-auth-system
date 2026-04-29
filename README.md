# JWT Authentication System (Spring Boot)

A secure backend authentication system built using Spring Boot and JWT (JSON Web Token).

---

## Features

* User Registration
* Login with JWT Token
* Password Encryption (BCrypt)
* Role-Based Authorization (USER / ADMIN)
* Protected APIs using JWT Filter
* Global Exception Handling

---

## Tech Stack

* Java 21
* Spring Boot
* Spring Security
* JWT (jjwt)
* MySQL
* Maven

---

## Core API Endpoints

### Authentication

* `POST /api/auth/register` → Register new user
* `POST /api/auth/login` → Login & get JWT token

### Protected

* `GET /api/auth/users` → Get all users (ADMIN only)

---

## Postman Collection

All APIs are tested and documented using Postman with:

* Valid authentication
* Invalid credentials
* Unauthorized access
* Duplicate registration

Import the collection to test endpoints easily:

* Download: `jwt-auth-system.postman_collection.json`
* Import into Postman
* Run APIs in sequence (Register → Login → Protected APIs)

---

##  Authentication Flow (Important)

1. Register a user
2. Login to receive JWT token
3. Copy token
4. Use it in Authorization tab:

```
Bearer <your_token>
```

5. Access protected APIs

---

## How JWT Works

1. User logs in
2. Server generates JWT token
3. Client sends token in Authorization header
4. Server validates token for protected APIs

---

## How to Run

1. Clone the repository
2. Configure MySQL in `application.properties`
3. Run the application
4. Test APIs using Postman

---

## Author

Saumya Jain
