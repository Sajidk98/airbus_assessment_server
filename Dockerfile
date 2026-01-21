# Use Maven + JDK image
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom first to cache dependencies
COPY pom.xml .

# Download dependencies only
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the jar
RUN mvn clean package -DskipTests

# Run stage
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/shopping-demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
