FROM openjdk:17
ADD target/ms-aggregator-0.0.1-SNAPSHOT.jar ms-aggregator-0.0.1-SNAPSHOT.jar
EXPOSE "${SERVER_PORT}"
ENTRYPOINT ["java", "-jar", "ms-aggregator-0.0.1-SNAPSHOT.jar"]