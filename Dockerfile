FROM openjdk:11.0.11-jre-slim
WORKDIR /app
ARG JAR_NAME=learning-project-0.1-all.jar


COPY jarbuild/$JAR_NAME /app/$JAR_NAME
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/learning-project-0.1-all.jar"]