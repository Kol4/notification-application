# Notification-Service

## Technology List
* Spring Cloud Netflix Eureka
* Spring Cloud Config
* Spring Cloud Gateway
* Spring Boot
* Docker
* Swagger
* Postgres

## Starting services locally without Docker

Every microservice is a Spring Boot application and can be started locally using IDE or `.mvn package`command and run -jar. Please note that supporting services (Config and Discovery Server) must be started before any other application.
In the project directory you can also find video, which demonstrate the workability of application.
Also, in the project direction placed postman collection file with tests.
If everything goes well, you can access the following services at given location:
* Discovery Server - http://localhost:8061
* Config Server - http://localhost:8088
* API Gateway - http://localhost:8060
* Registration Service - http://localhost:8080
* Notification Sender Service - http://localhost:8090
* Notification Creator Service - http://localhost:8100

You can tell Config Server to use your local Git repository by using `native` Spring profile and setting
`GIT_REPO` environment variable, for example:
`-Dspring.profiles.active=native

## Architecture

Our sample microservices-based system consists of the following modules:
- **gateway-service** - a module that Spring Cloud Gateway for running Spring Boot application that acts as a proxy/gateway in our architecture.
- **config-service** - a module that uses Spring Cloud Config Server for running configuration server. The configuration files are placed on the classpath.
- **discovery-service** - a module that depending on the example it uses Spring Cloud Netflix Eureka or Spring Cloud Netlix Alibaba Nacos as an embedded discovery server.
- **registration-service** - a module containing the first of our microservices that allows to perform CRUD operation on users
- **sender-service** - a module containing the second of our microservices that allows to send notification to Firebase. 
- **creator-service** - a module containing the third of our microservices that allows to perform CRUD operation on notifications. It communicates with both registration-service and sender-service.

The following picture illustrates the architecture described above.

![image](https://user-images.githubusercontent.com/43250623/197522005-a683633f-1e9f-40df-a8cd-0fa9c248d89c.png)





