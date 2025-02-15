FROM openjdk:17-jdk-slim

WORKDIR /parcial

COPY out/artifacts/parcial_jar/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
