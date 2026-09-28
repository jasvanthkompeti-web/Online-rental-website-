# Electronics Rental Platform

A Spring Boot + PostgreSQL electronics rental platform for laptops, iPhones, cameras, tablets and gaming devices.

## Run locally
1. Install Java 17+, Maven, and PostgreSQL.
2. Create a PostgreSQL database named `rentaldb`.
3. Update `backend/src/main/resources/application.properties` if your PostgreSQL username/password differ.
4. From `backend/` run:
   `mvn spring-boot:run`
5. Open `http://localhost:8080`

The frontend is served by Spring Boot from `src/main/resources/static`.

## Render
This repository includes `render.yaml`. Push the project to GitHub, create a Render Blueprint from the repository, and Render will create the web service and PostgreSQL database.

## Demo admin
The app seeds a few products. For production, add proper authentication/authorization and payment processing before accepting real payments.
