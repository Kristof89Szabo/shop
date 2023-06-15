FROM openjdk:11.0.11-jre-slim
WORKDIR /app

COPY jarbuild/learning-project-0.1-all.jar /app/learning-project-0.1-all.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/learning-project-0.1-all.jar"]
