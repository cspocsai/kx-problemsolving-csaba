#Naming-Service

Naming-Service [Spring Boot](http://projects.spring.io/spring-boot/) app for KX Problem solving exercise.
This application contains built in Eureka naming server for service discovery.

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/downloads/#java11)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.kx.naming.server.NamingServerApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Running this application with Docker

The easiest way to run the application and its dependencies using Docker to navigate to the docker folder and run the following command:

```shell
docker-compose up --build
```

Once the application launched successfully you can open up your browser and monitor the registered services if any:
 - http://localhost:8761

You should see something similar:
![img.png](img.png)