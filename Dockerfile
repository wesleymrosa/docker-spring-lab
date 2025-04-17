# Etapa de build
FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/docker-spring-lab-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=docker"]
