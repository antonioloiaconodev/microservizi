FROM openjdk:17
ADD target/ms-comment-0.0.1-SNAPSHOT.jar ms-comment-0.0.1-SNAPSHOT.jar
EXPOSE "${SERVER_PORT}"
ENTRYPOINT ["java", "-jar", "ms-comment-0.0.1-SNAPSHOT.jar"]