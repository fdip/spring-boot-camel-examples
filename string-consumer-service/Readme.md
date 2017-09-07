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




