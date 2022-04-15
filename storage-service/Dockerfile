#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/app/target/storage-service-1.0.0-SNAPSHOT.jar /usr/local/lib/storage-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/usr/local/lib/storage-service.jar"]