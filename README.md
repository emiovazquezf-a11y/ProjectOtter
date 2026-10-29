# Social MMO

A third-person 3D social MMO for Steam.

## Stack
- Godot 4 client and headless world server (planned)
- Java 21 + Spring Boot API
- MySQL 8.4
- Spring Data JPA / Hibernate
- Liquibase database migrations
- Docker Compose for local MySQL

## Run locally
1. Install Java 21, Maven, Docker and Docker Compose.
2. Run `docker compose up -d`.
3. Run `cd backend && mvn spring-boot:run`.
4. Visit `http://localhost:8080/actuator/health`.

This starter contains the API foundation and placeholders for the Godot projects. Steam authentication and multiplayer are NOT implemented yet.

## Next steps
- Steam ticket validation and backend sessions
- Player profile endpoints
- Inventory, catalog and coin ledger
- Godot 4 client and dedicated world server
- Secure service-to-service authentication
