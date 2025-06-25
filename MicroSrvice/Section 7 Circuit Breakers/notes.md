# Circuit Breakers
To implement circuit breakers we need to add the following dependencies to our pom.xml file:

```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

Then we can use the @CircuitBreaker annotation to define a circuit breaker. on top of the method.

```
   @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
   @Override
   public EmployeeResponseDto getEmployee(Long employeeId) {
   
   }
```

The fallbackMethod is the method that will be called if the circuit breaker is open.
```
   public EmployeeResponseDto getDefaultDepartment(Long employeeId) {
       return new EmployeeResponseDto();
   }
```

Then configure the circuit breaker in the application.properties file:
```
# Actuator endpoints for circuit breaker
management.health.circuitbreakers.enabled=true
management.endpoints.web.exposure.include=health
management.endpoint.health.show-details=always

# Circuit breaker configuration
resilience4j.circuitbreaker.instances.EMPLOYEE-SERVICE.registerHealthIndicator=true
resilience4j.circuitbreaker.instances.EMPLOYEE-SERVICE.failureRateThreshold=50
resilience4j.circuitbreaker.instances.EMPLOYEE-SERVICE.minimumNumberOfCalls=5
resilience4j.circuitbreaker.instances.EMPLOYEE-SERVICE.automaticTransitionFromOpenToHalfOpenEnabled=true
resilience4j.circuitbreaker.instances.EMPLOYEE-SERVICE.waitDurationInOpenState=5s
resilience4j.circuitbreaker.instances.EMPLOYEE-SERVICE.permittedNumberOfCallsInHalfOpenState=3
resilience4j.circuitbreaker.instances.EMPLOYEE-SERVICE.slidingWindowSize=10
resilience4j.circuitbreaker.instances.EMPLOYEE-SERVICE.slidingWindowType=count_based
```

now we can check if the circuit breaker is open using the actuator endpoints:
```
http://localhost:8081/actuator/health
```

If the circuit breaker is open or half open, developer need to get action to close the circuit breaker.

## To run retry pattern
```
# Retry configuration
resilience4j.retry.instances.EMPLOYEE-SERVICE.registerHealthIndicator=true
resilience4j.retry.instances.EMPLOYEE-SERVICE.maxRetryAttempts=5
resilience4j.retry.instances.EMPLOYEE-SERVICE.waitDuration=2s
```

need to change function to return EmployeeResponseDto
```
   @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
   @Override
   public EmployeeResponseDto getEmployee(Long employeeId) {
   
   }
```
