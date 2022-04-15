#Storage-Service

Storage-Service [Spring Boot](http://projects.spring.io/spring-boot/) app for KX Problem solving exercise.
This application stores in-memory, dummy employee data that can be accessed through a REST GET call in JSON format.
I used [Redis](https://redis.io) as an in-memory cache in my soluation.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/downloads/#java11)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.kx.storage.service.StorageServiceApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run -D"spring-boot.run.jvmArguments"="-Dspring.profiles.active=local"
```

## Running this application with Docker

The easiest way to run the application and its dependencies using Docker to navigate to the docker folder and run the following command:

```shell
docker-compose up --build
```

Once the application launched successfully you can try out this application. One endpoint available here (except Actuator endpoints):
 - /employee/all: it returns the list of employees in Redis
```json
[
  {
    "name": "Willie Rippin",
    "address": "0367 Jerrell Forest",
    "sex": "Male",
    "phoneNumber": "1-666-114-0865 x1036",
    "position": "Orchestrator",
    "title": "Global IT Manager"
  },
  {
    "name": "Fernando Schaefer",
    "address": "4789 Lubowitz Plain",
    "sex": "Female",
    "phoneNumber": "401.584.1765 x62698",
    "position": "Director",
    "title": "Marketing Specialist"
  },
  {
    "name": "Aurore O'Reilly",
    "address": "10707 McLaughlin Pike",
    "sex": "Male",
    "phoneNumber": "804.140.8256 x5375",
    "position": "Director",
    "title": "Manufacturing Administrator"
  },
  {
    "name": "Lashawn Huels III",
    "address": "6155 Britany Rapids",
    "sex": "Male",
    "phoneNumber": "1-966-846-8997 x86783",
    "position": "Supervisor",
    "title": "Community-Services Engineer"
  }
]
```