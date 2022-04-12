FROM openjdk:17
ADD target/ms-eureka-0.0.1-SNAPSHOT.jar ms-eureka-0.0.1-SNAPSHOT.jar
EXPOSE "${SERVER_PORT}"
ENTRYPOINT ["java", "-jar", "ms-eureka-0.0.1-SNAPSHOT.jar"]