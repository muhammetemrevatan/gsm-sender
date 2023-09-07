FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/gsm-sender-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]