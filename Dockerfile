FROM openjdk:8
LABEL maintainer="shrestha.asm@gmail.com"
ADD target/spring-batch.jar spring-batch.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "spring-batch.jar"]