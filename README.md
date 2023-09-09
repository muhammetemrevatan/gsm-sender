# GsmSenderApplication

GsmSenderApplication is a Spring Boot based REST API application. This project has been developed to establish a backend service utilized to manage and send GSM messages. Rooted in modern software development techniques and various design patterns, the project embodies a scalable and maintainable structure.

## Features

### Core Technologies and Principles

1. **Java 17**: The project is developed using the current and efficient version of Java 17.

2. **Spring Boot**: Facilitates the development of modern Spring-based applications swiftly and easily.

3. **OOP Foundations**: The project is developed adhering to the principles of Object-Oriented Programming (OOP).

4. **Java Reflection**: Manages the properties and functionalities of objects dynamically.

### Design Patterns

1. **Factory Pattern**: Provides a modular and extensible code base.

2. **Strategy Pattern**: Facilitates the flexible use of different algorithms within the application.
   

***The design patterns mentioned above, taking into consideration the principles of OOP and the reflection feature of the Java language, have been utilized to develop a solution for directing a request, which might come through three different DTOs, to the appropriate Java classes, by considering the solutions that these three features can offer.***


### Tools and Integrations

1. **Swagger**: A user-friendly API documentation tool that eases the use and testing of the API.

    - Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

2. **Docker & Docker Compose**: Utilized for containerizing the application and facilitating easy management.

3. **Actuator**: Allows the monitoring of the application's health status and other metrics.

4. **Prometheus & Grafana**: Assist in observing and analyzing the performance and other metrics of the application.

5. **Grafana**: An open-source platform for monitoring and observability that integrates with Prometheus to offer comprehensive insights through data visualization and dashboards.

6. **Logback**: A robust and flexible logging solution.

## Installation and Usage

### Prerequisites

- Maven
- Java 17
- Spring Boot 2.7.15

### Running Locally

1. Clone the project to your local machine.
   ```bash
   git clone https://github.com/muhammetemrevatan/gsm-sender.git
    ```
2. Navigate to the project directory and start the application with Maven.
    ```bash
    cd gsm-sender
    mvn spring-boot:run
    ```
3. Once the application has started, you can open the Swagger UI to utilize the API documentation and testing tools.

### Running with Docker
1. Install and initiate Docker and Docker Compose.
2. Navigate to the project directory and start the application with Docker Compose.
    ```bash
    cd gsm-sender
    cd src
    cd docker
    docker-compose up -d
    ```
3. Once the application has started, you can open the Swagger UI to utilize the API documentation and testing tools.
