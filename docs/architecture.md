# Architecture v1

Steam/Godot Client
- HTTPS -> Spring Boot API (Steam ticket validation, player data, economy)
- ENet/UDP -> Godot headless world server (movement, interactions, room state)

Spring Boot API -> MySQL via Spring Data JPA/Hibernate
Liquibase owns database schema migrations.

## Security
Never trust client-provided Steam IDs, balances, inventory, positions or rewards.
Verify Steam auth tickets server-side before issuing short-lived join credentials.
Game server uses authenticated backend calls for persistent mutations.
Do not expose MySQL to the public internet.
