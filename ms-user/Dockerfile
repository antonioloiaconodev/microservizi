FROM openjdk:17
ADD target/ms-user-0.0.1-SNAPSHOT.jar ms-user-0.0.1-SNAPSHOT.jar
EXPOSE "${SERVER_PORT}"
ENTRYPOINT ["java", "-jar", "ms-user-0.0.1-SNAPSHOT.jar"]