# poller-service

## Overview
continuously polls from the string-generator-service and post to the string-consumer-service (runs on port: 8080)

### Technology stack
 - Java 8 
 - Spring Boot 
 - Camel 
 - mvn 

## Getting Started

### System requirements
 - Java 8

###Dependencies
**To work properly needs running**:
- string-consumer-service   
- string-generator-service 
### Running it locally
```mvn spring-boot:run```

## How to guides

### How to run tests
```mvn clean test```
### How to build it from command line
```mvn clean package```




