# Spring Security

We can add spring security by adding this dependency to pom xml

```
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
```

After add this its automatically applying the spring security filters to our APIs

# Give custom auth privileges to api endpoint

create configuration class in config package and we can give api access like as follow

```
@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests()
                .antMatchers("/api/v1/account/my-account", "/api/v1/loan/my-loan").authenticated()
                .antMatchers("/api/v1/notice/my-notice").permitAll()
                .and().formLogin().and().httpBasic();

        return httpSecurity.build();
    }
}
```
