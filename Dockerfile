FROM openjdk:11.0.11-jre-slim

COPY build/libs/learning-project-0.1-all.jar learning-project-0.1-all.jar

ENTRYPOINT ["java", "-jar", "learning-project-0.1-all.jar"]