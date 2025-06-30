# Spring Boot WebFlux
## What is WebFlux?
Spring WebFlux is a reactive web framework introduced in Spring 5. It is used for building non-blocking, asynchronous, event-driven applications using the Reactive Streams API.

It supports two programming styles:

Annotation-based (@RestController) (like Spring MVC)

Functional Routing (RouterFunction & HandlerFunction)

## Reactive Types (From Project Reactor)
| Type      | Description     | Example                    |
| --------- | --------------- | -------------------------- |
| `Mono<T>` | 0 or 1 item     | `Mono.just("Hello")`       |
| `Flux<T>` | 0 or many items | `Flux.just("A", "B", "C")` |


Use Mono when you're expecting a single result, Flux when you're expecting a stream (list).

### RouterFunction (Functional Endpoints)
📍 Example:

```
@Configuration
public class RouterConfig {
@Bean
public RouterFunction<ServerResponse> route(UserHandler handler) {
    return RouterFunctions
        .route(GET("/users"), handler::getAllUsers)
        .andRoute(GET("/users/{id}"), handler::getUserById)
        .andRoute(POST("/users"), handler::createUser);
    }
}
```
### HandlerFunction

```
@Component
public class UserHandler {

    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        Flux<User> users = userService.getAllUsers(); // returns Flux<User>
        return ServerResponse.ok().body(users, User.class);
    }

    public Mono<ServerResponse> getUserById(ServerRequest request) {
        String id = request.pathVariable("id");
        Mono<User> user = userService.getUserById(id); // returns Mono<User>
        return ServerResponse.ok().body(user, User.class);
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return userMono.flatMap(user ->
            userService.saveUser(user)
                       .flatMap(savedUser ->
                           ServerResponse.ok().bodyValue(savedUser)
                       )
        );
    }
}
```


### ServerResponse & ServerRequest
ServerRequest → used to get data from HTTP request (path variables, query params, body).

ServerResponse → used to send response (status, headers, body).

### Common Annotations (Optional Approach)
You can still use:
```
@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

```
### Threading & Schedulers
WebFlux uses Reactor Netty by default.

Non-blocking: avoid using traditional blocking APIs (e.g., JDBC).

Use .subscribeOn(Schedulers.boundedElastic()) for blocking calls like DB.


 ## WebFlux Dependency
```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-webflux</artifactId>
</dependency>

```
