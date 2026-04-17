# Clinica App

Aplicación backend simple en Spring Boot para manejar datos de médicos en una clínica.

## Qué hace

- Provee una API REST para gestionar **médicos**.
- Permite listar, consultar, crear, actualizar y eliminar médicos.
- Usa un repositorio en memoria con datos iniciales de ejemplo.

> La entidad de paciente está definida en el modelo, pero actualmente no tiene controladores ni servicios completos.

## Equipo de Trabajo

- Juan Camilo 
- Haner Camilo Perea

## Endpoints disponibles

- `GET /api/doctors` — lista todos los médicos
- `GET /api/doctors/{id}` — obtiene un médico por ID
- `POST /api/doctors` — crea un nuevo médico
- `PUT /api/doctors/{id}` — actualiza un médico existente
- `DELETE /api/doctors/{id}` — elimina un médico

## Estructura principal

- `src/main/java/com/devsenior_sala3/clinica_app` — aplicación principal
- `controller/DoctorController.java` — API REST de médicos
- `service/*` — lógica de negocio para médicos
- `repository/DoctorRepository.java` — datos en memoria
- `model/Doctor.java` — modelo de médico
- `model/Pacient.java` — modelo de paciente (en desarrollo)

## Tecnologías

- Java 17
- Spring Boot 4
- Spring Web MVC
- SpringDoc OpenAPI
- Maven

## Cómo ejecutar

1. Abrir el proyecto en un IDE o terminal.
2. Ejecutar:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Acceder a la API en `http://localhost:8080/swagger-ui/index.html`.

## Notas

- No usa base de datos; los médicos se guardan en memoria mientras la aplicación está en ejecución.
- Para producción se recomienda agregar persistencia real y validación más completa.
