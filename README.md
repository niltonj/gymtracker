# GymTracker

Esqueleto full-stack para acompanhar treinos: **Spring Boot 3 + React (Vite + TS + Tailwind)**.

## Como rodar

1) Banco (Docker)
```bash
cd dev && docker compose up -d
```

2) Backend
```bash
cd backend
mvn spring-boot:run
# Swagger: http://localhost:8080/swagger-ui/index.html
```

3) Frontend
```bash
cd frontend
npm i
npm run dev
# App: http://localhost:5173
```

## Estrutura rápida
- backend/: Spring Boot, JPA, Flyway, OpenAPI.
- frontend/: React + Vite + TS + Tailwind, React Query, Router, Recharts.
- dev/: Docker Compose (Postgres) e seed.
- .github/workflows/ci.yml: workflow simples de build.
