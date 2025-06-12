# Creating Config Server
create project from spring initializr by adding following dependencies

```
<dependency>
    <groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-config-server</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
Add @EnableConfigServer and
@EnableEurekaClient annotations to ConfigServerApplication class (Main class) to enable config server and mark as eureka client

## Add configuration properties in application.properties
```
spring.application.name=CONFIG-SERVER
server.port=8888
eureka.instance.client.serverUrl.defaultZone=http://localhost:8761/eureka

#Initializing git repo
spring.cloud.config.server.git.uri=https://github.com/IT20167028/configuration-server-repo.git

# Tell service to clone the repo on startup
spring.cloud.config.server.git.clone-on-start=true

# Specify the branch to use
spring.cloud.config.server.git.default-label=main
```

### Add configuration properties to config client with following dependencies
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>
```

commented on configuration properties and add only need to add server name and config server url
```
spring.application.name=DEPARTMENT-SERVICE
spring.config.import=optional:configserver:http://localhost:8888
```

#### If configurations changed we have to manually refresh the config client application, so over come this we can use actuator endpoints
```
curl -X POST http://localhost:8080/actuator/refresh
```

# To Refresh Configuration automatically
add rabbitmq dependency to client projects in pom.xml
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-bus-amqp</artifactId>
</dependency>
```
After that pull docker image from docker hub
```
docker pull rabbitmq
docker run --rm -it -p 5672:5672 rabbitmq:3.11.0
```
Add rabbitmq configuration in application.properties
```
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest
```
### Update Configurations using bus
```
curl -X POST http://localhost:8080/actuator/busrefresh
```

After execute this post request it will send refresh event to bus and config server will reconfigure the application