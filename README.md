# Spring Boot Camel examples

## Overview

Demo of spring boot camel integration

### Technology stack
 - Java 8 
 - Spring Boot 
 - Spring Data 
 - Camel 
 - H2 
 - Cucumber
 - mvn 
 - Hystrix
 - Hystrix dashbord
 - Hawtio

### Architecture

An overview of the main architecture
Project contains of four microservices:
 - string-generator-service expose a GET endpoint that returns randomly generated messages (runs on port: 8082)
 - poller-service continuously polls from the string-generator-service and post to the string-consumer-service (runs on port: 8080)
 - string-consumer-service exposes a POST endpoint to store message into the database 
 and runs the camel cron job to get all messages from db and send it to FTP server(runs on port: 8081)


## Getting Started

### System requirements
 - Java 8
 - FTP server
 - mvn

### Build it from source
To build all projects run:

```mvn clean package```
### Running it locally
See description in each project:

 [string-consumer-service](/string-consumer-service/README.md/)    
 [string-generator-service](/string-generator-service/README.md/)    
 [poller-service](/poller-services/README.md/)   

## How to guides

### How to run tests
```mvn clean test```
### How to build it from command line
```mvn clean package```

