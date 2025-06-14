# Distributed Tracing
Add relevant dependencies to api  and other client services pom.xml
```
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
```

So after that hit endpoint from api-gateway. then after that check log for distributed tracing
then we can find distributed tracing id in log 

```
[DEPARTMENT-SERVICE,8c5ea9c8872e613d,8c5ea9c8872e613d]
[EMPLOYEE-SERVICE,8c5ea9c8872e613d,dfeb4c06257e0208]
```

this is trace id 8c5ea9c8872e613d and 8c5ea9c8872e613d, dfeb4c06257e0208 is span id.
1. trace id - this is unique for each request
2. span id - this is unique for each micro service

this is how we can find distributed tracing using log. this is very difficult concept, to overcome that we can use zipkin.

# Zipkin
Download zipkin server or run zipkin server in docker

```
# Run zipkin server
java -jar zipkin-server-3.5.1-exec.jar

# Run zipkin server in docker
docker pull openzipkin/zipkin
docker run -d --name zipkin-container -p 9411:9411 openzipkin/zipkin
```

Add Zipkin dependencies to clients pom.xml
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-sleuth-zipkin</artifactId>
</dependency>
```

Add zipkin base url to application properties
```
spring.zipkin.base-url=http://localhost:9411
#Normally zip kin server trace 10% of requests, so we can change it to 100%
spring.sleuth.sampler.probability=1 
```