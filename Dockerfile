FROM openjdk:11.0.11-jre-slim

COPY app.jar .

ENTRYPOINT ["java", "-jar", "learning-project-0.1-all.jar"]