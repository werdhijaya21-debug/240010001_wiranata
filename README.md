# Todo API - UAS Pemrograman Komputer

REST API Task Management menggunakan:

- Java Spring Boot 3.5
- Spring Data JPA
- H2 Database

## Cara Menjalankan

1. Clone repository
2. Jalankan:

mvn spring-boot:run

Server berjalan di:

http://localhost:8081

## Endpoint

POST   /api/categories
GET    /api/categories

POST   /api/tasks
GET    /api/tasks
GET    /api/tasks/{id}
PUT    /api/tasks/{id}
PATCH  /api/tasks/{id}/status
DELETE /api/tasks/{id}
