# Spring Boot Movie API

A simple Spring Boot REST API deployed on AWS EC2 using MongoDB.

## Tech Stack

- Java 17
- Spring Boot
- MongoDB
- AWS EC2
- Maven

---

# Base URL

```text
http://3.7.69.0:8080/api/v1/movie
```

---

# API Endpoints

## 1. Get All Movies

### Endpoint

```http
GET /getMovies
```

### Full URL

```text
http://3.7.69.0:8080/api/v1/movie/getMovies
```

### Response Example

```json
[
  {
    "id": "550e8400-e29b-41d4-a716-446655440000",
    "name": "Interstellar",
    "rating": 10
  }
]
```

---

## 2. Add Movie

### Endpoint

```http
POST /
```

### Full URL

```text
http://3.7.69.0:8080/api/v1/movie
```

### Request Body

```json
{
  "name": "The Dark Knight",
  "rating": 9
}
```

---

## 3. Get Movie By ID

### Endpoint

```http
GET /{id}
```

### Example

```text
http://3.7.69.0:8080/api/v1/movie/550e8400-e29b-41d4-a716-446655440000
```

### Success Response

```json
{
  "id": "550e8400-e29b-41d4-a716-446655440000",
  "name": "Interstellar",
  "rating": 10
}
```

---

## 4. Delete Movie By ID

### Endpoint

```http
DELETE /{id}
```

### Example

```text
http://3.7.69.0:8080/api/v1/movie/550e8400-e29b-41d4-a716-446655440000
```

---

# Deployment

Application deployed on:
- AWS EC2
- MongoDB running on EC2 instance

---

# Run Locally

## Build

```bash
mvn clean package
```

## Run

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

# Author

Nidhi Sharma
