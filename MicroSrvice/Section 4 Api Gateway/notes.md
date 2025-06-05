# Creating Api Gateway

Go to spring initializr and create new api gateway project with following dependencies

1. spring-cloud-starter-gateway
2. spring-cloud-starter-netflix-eureka-client
3. spring-boot-starter-actuator

# Change the application properties

```
spring.application.name=API-Gateway
server.port=9191

eureka.instance.client.serverUrl.defaultZone=http://localhost:8761/eureka
```

##### API Gateway run on top of Netty server instead of Tomcat

## Add routes to application.properties (Configure routes manually)

```
# add lb:// to route to the load balancer
spring.cloud.gateway.routes[0].id=EMPLOYEE-SERVICE
spring.cloud.gateway.routes[0].uri=lb://EMPLOYEE-SERVICE
spring.cloud.gateway.routes[0].predicates[0]=Path=/api/employee/**

spring.cloud.gateway.routes[1].id=DEPARTMENT-SERVICE
spring.cloud.gateway.routes[1].uri=lb://DEPARTMENT-SERVICE
spring.cloud.gateway.routes[1].predicates[0]=Path=/api/departments/**
```

#### To Call api through gateway - http://localhost:9191/api/employee/getById/1

### Configure routes dynamically
```angular2html
#Dynamic Configuration
spring.cloud.gateway.discovery.locator.enabled=true
spring.cloud.gateway.discovery.locator.lower-case-service-id=true
logging.level.org.springframework.cloud.gateway.handler.RoutePredicateHandlerMapping=DEBUG # Debug logs for routes
```
#### To Call api through gateway - http://localhost:9191/employee-service/api/employee/getById/1