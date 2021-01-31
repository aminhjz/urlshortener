FROM openjdk:11-jdk
EXPOSE 8080
ARG JAR_FILES=target/*.jar
ADD ${JAR_FILES} /app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]