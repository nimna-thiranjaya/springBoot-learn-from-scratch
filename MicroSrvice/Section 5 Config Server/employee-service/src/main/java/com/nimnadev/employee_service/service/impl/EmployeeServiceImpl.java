package com.nimnadev.employee_service.service.impl;

import com.nimnadev.employee_service.dto.DepartmentDto;
import com.nimnadev.employee_service.dto.EmployeeDto;
import com.nimnadev.employee_service.dto.EmployeeResponseDto;
import com.nimnadev.employee_service.entity.Employee;
import com.nimnadev.employee_service.repository.EmployeeRepository;
import com.nimnadev.employee_service.service.APIClient;
import com.nimnadev.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

//    @Autowired
//    private RestTemplate restTemplate;

//    @Autowired
//    private WebClient webClient;

    @Autowired
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail(),
                savedEmployee.getDepartmentCode()
        );

        return savedEmployeeDto;
    }

    @Override
    public EmployeeResponseDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        // Inter Services communication with restTemplate make sure to add restTemplate bean in application class
        // String departmentUrl = "http://localhost:8080/api/departments/getByCode/" + employee.getDepartmentCode();
        // ResponseEntity<DepartmentDto> departmentResponse = restTemplate.getForEntity(departmentUrl, DepartmentDto.class);
        // DepartmentDto departmentDto = departmentResponse.getBody();


        // Inter Services communication with WebClient make sure to add webClient bean in application class
        // String departmentUrl = "http://localhost:8080/api/departments/getByCode/" + employee.getDepartmentCode();
        // DepartmentDto departmentDto = webClient.get()
        // .uri(departmentUrl)
        // .retrieve()
        // .bodyToMono(DepartmentDto.class)
        // .block();

        // Inter Services communication with FeignClient make sure to add APIClient interface
        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        return new EmployeeResponseDto(employeeDto, departmentDto);
    }
}
