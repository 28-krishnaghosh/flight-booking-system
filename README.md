# Flight Booking System - Backend
Scalable Flight Booking REST APIs built with Java 21, Spring Boot & PostgreSQL.

## Tech Stack
- Java 21, Spring Boot 3
- Spring Data JPA, PostgreSQL
- Maven, REST APIs

## Features
- Add & Search Flights
- Create Booking with Seat Class
- Get Booking by ID
- Cancel Booking

## API Endpoints
POST /api/flights - Add new flight
GET /api/flights/search?from=DEL&to=BOM - Search flights
POST /api/bookings - Create booking
GET /api/bookings/{id} - Get booking details
DELETE /api/bookings/{id} - Cancel booking

## How to Run
1. Create DB flightdb in PostgreSQL
2. Update application.properties
3. Run: mvn spring-boot:run
