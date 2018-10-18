FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/billing-service-info-v1-1.0-SNAPSHOT.jar target/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/app.jar"]





