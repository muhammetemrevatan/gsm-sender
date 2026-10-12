# GSM Message Sender Service

A Spring Boot REST API that routes message requests to provider-specific handlers using a typed request model and a strategy-style service map.

> **Current behavior:** this is a routing and API-structure demo. The `NETRO`, `LIGHT`, and `LOGI` handlers currently print request fields to the application console; they do not connect to a GSM/SMS provider or send messages. Do not send real or sensitive recipient data to this demo.

## Features

- One endpoint accepts requests for three message formats: `NETRO`, `LIGHT`, and `LOGI`
- A dedicated handler is selected for each request type
- OpenAPI documentation with Swagger UI
- Health and Prometheus metrics endpoints through Spring Boot Actuator
- Docker Compose setup for the API, Prometheus, and Grafana

## Technology

- Java 17
- Spring Boot 2.7.15
- Maven
- Spring Web and Jackson
- Spring Boot Actuator and Micrometer Prometheus registry
- springdoc OpenAPI
- Docker Compose, Prometheus, and Grafana

## Run locally

Prerequisites: JDK 17 and Maven. Docker is only needed for the monitoring stack.

From the repository root:

```bash
mvn test
mvn spring-boot:run
```

The API listens on port `8080` by default.

## Send a routing request

`POST /api/gsm/send` accepts a `gsmRequestType` and a matching `gsmRequestObj`.

```bash
curl -X POST http://localhost:8080/api/gsm/send \
  -H 'Content-Type: application/json' \
  -d '{
    "gsmRequestType": "NETRO",
    "gsmRequestObj": {
      "to": "+15555550123",
      "subject": "Example",
      "message": "Test message"
    }
  }'
```

Supported request types and fields:

| Type | Fields |
| --- | --- |
| `NETRO` | `to`, `message`, `subject` |
| `LIGHT` | `to`, `message` |
| `LOGI` | `to`, `message`, `cc`, `subject` |

The controller currently returns an empty successful response when routing completes. The selected handler writes the received values to the application log/console; this does not confirm delivery to a recipient.

## API and monitoring endpoints

When the application is running locally:

- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- OpenAPI JSON: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
- Health: [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health)
- Prometheus metrics: [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus)

## Run with Docker Compose

Build the application JAR first, then start the API and monitoring services:

```bash
mvn clean package
docker compose -f src/docker/docker-compose.yml up --build -d
```

The Compose file publishes the API on `8080`, Prometheus on `9090`, and Grafana on `3000`. Use `docker compose -f src/docker/docker-compose.yml logs -f app` to follow the API logs, and `docker compose -f src/docker/docker-compose.yml down` to stop the stack.

The included monitoring configuration is intended for local development. The Grafana admin password is currently configured in the Compose file; change it before exposing Grafana beyond a trusted local environment. Prometheus targets `host.docker.internal:8080`, which may need to be changed to the Compose service name (`app:8080`) on Linux Docker setups.

## Project structure

```text
src/main/java/.../controller/   REST API endpoint
src/main/java/.../dto/          Request and provider payload models
src/main/java/.../enums/        Supported request types
src/main/java/.../service/      Routing contract and provider handlers
src/main/resources/             Spring and logging configuration
src/docker/                     Compose, Prometheus, and alert configuration
src/test/                       Controller and application tests
```

## Production considerations

Before connecting a real provider, implement and test its transport/authentication in the corresponding handler. Add authentication, request validation, rate limiting, delivery/error reporting, and safe handling of recipient data before exposing the endpoint publicly. Avoid logging message contents or phone numbers in production.
