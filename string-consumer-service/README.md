
# string-consumer-service

## Overview

exposes a POST endpoint to store message into the database 
and runs the camel cron job to get all messages from db and send it to FTP server(runs on port: 8081)


### Technology stack
 - Java 8 
 - Spring Boot 
 - Spring Data 
 - H2 
 - Cucumber
 - mvn 
 - Hystrix

## Getting Started

### System requirements
 - Java 8
 - FTP server
 - mvn
 
### Running it locally
```mvn spring-boot:run```

Download a [one-ftpserver](https://github.com/benelog/one-ftpserver) and run it using below command:
```
java -jar one-ftpserver.jar port=10021 id=pionieerlabs password=changeme
```
## Features

### Endpoints
- **<code>POST</code> api/v1/messages** - save new message in db

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







