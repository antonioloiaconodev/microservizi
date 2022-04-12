FROM openjdk:17
ADD target/ms-videogame-0.0.1-SNAPSHOT.jar ms-videogame-0.0.1-SNAPSHOT.jar
EXPOSE "${SERVER_PORT}"
ENTRYPOINT ["java", "-jar", "ms-videogame-0.0.1-SNAPSHOT.jar"]