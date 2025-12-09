# Step 1: Use an official OpenJDK base image from Docker Hub
FROM openjdk:17.0.1-jdk-slim
# Step 2: Set the working directory inside the container

RUN apt-get -y update; apt-get -y install curl
WORKDIR /app
RUN groupadd auth && useradd -g auth -m -s /bin/bash auth
USER auth:auth
ARG JAR_FILE=exposition/target/*.jar
# Step 3: Copy the Spring Boot JAR file into the container
COPY ${JAR_FILE} /app/app.jar
COPY exposition/src/main/resources/application.yml /app/config.yml
# Step 4: Expose the port your application runs on
EXPOSE 8080
# Step 5: Define the command to run your Spring Boot application
CMD ["java", "-jar", "/app/app.jar", "--spring.config.location=/app/config.yml"]
#ENTRYPOINT ["java","-jar","/app.jar"]