# To Run same service on another port
 Create maven package and run jar using following command. you can run any number of services on different ports using this command
 
``java -jar target/department-service-0.0.1-SNAPSHOT.jar --server.port=8082
``

## Connect with registered service with feign client

``@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/getByCode/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable("departmentCode") String departmentCode);
}
``