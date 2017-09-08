# string-generator-service

## Overview

expose a GET endpoint that returns randomly generated messages (runs on port: 8082)


### Technology stack
 - Java 8 
 - Spring Boot 
 - Cucumber
 - mvn 


## Getting Started

### System requirements
 - Java 8


### Running it locally
```mvn spring-boot:run```
## Features

### Endpoints
- **<code>GET</code> api/messages** return new message

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




