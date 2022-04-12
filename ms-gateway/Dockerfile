FROM openjdk:17
ADD target/ms-gateway-0.0.1-SNAPSHOT.jar ms-gateway-0.0.1-SNAPSHOT.jar
EXPOSE "${SERVER_PORT}"
ENTRYPOINT ["java", "-jar", "ms-gateway-0.0.1-SNAPSHOT.jar"]