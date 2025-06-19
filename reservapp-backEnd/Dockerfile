FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/reservapp-0.0.1.jar
COPY ${JAR_FILE} reservapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "reservapp.jar"]
