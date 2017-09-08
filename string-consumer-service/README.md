# db-consumer-service

## Overview

runs the camel cron job to get all messages from db and send it to FTP server (runs on port: 8083)

### Technology stack
 - Java 8 
 - Spring Boot 
 - Spring Data 
 - Camel 
 - H2 
 - mvn 

## Getting Started

### System requirements
 - Java 8
 - FTP server

###Dependencies
 - needs running FTP server
### Running it locally
```mvn spring-boot:run```
## How to guides

### How to run tests
```mvn clean test```
### How to build it from command line
```mvn clean package```






# string-consumer-service

## Overview

exposes a POST endpoint to store message into the database (runs on port: 8081)


### Technology stack
 - Java 8 
 - Spring Boot 
 - Spring Data 
 - H2 
 - Cucumber
 - mvn 

## Getting Started

### System requirements
 - Java 8
 - FTP server
 - mvn

###Dependencies

### Running it locally
```mvn spring-boot:run```
## Features

### Endpoints
- **<code>POST</code> api/messages** - save new message in db

```$xslt
{
	 "id":1
	 "content":"Lorem Ipsum"
}
```

## How to guides

### How to run tests
```mvn clean test```
### How to build it from command line
```mvn clean package```







