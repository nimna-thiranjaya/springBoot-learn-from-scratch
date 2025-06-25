package com.nimnadev.employee_service.service.impl;

import com.nimnadev.employee_service.dto.DepartmentDto;
import com.nimnadev.employee_service.dto.EmployeeDto;
import com.nimnadev.employee_service.dto.EmployeeResponseDto;
import com.nimnadev.employee_service.entity.Employee;
import com.nimnadev.employee_service.repository.EmployeeRepository;
import com.nimnadev.employee_service.service.APIClient;
import com.nimnadev.employee_service.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WebClient webClient;

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

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

//    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public EmployeeResponseDto getEmployee(Long employeeId) {
        LOGGER.info("Inside Get Employee by id with id: " + employeeId);
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        // Inter Services communication with WebClient make sure to add webClient bean in application class
         String departmentUrl = "http://localhost:8080/api/departments/getByCode/" + employee.getDepartmentCode();
         DepartmentDto departmentDto = webClient.get()
         .uri(departmentUrl)
         .retrieve()
         .bodyToMono(DepartmentDto.class)
         .block();

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );

        return new EmployeeResponseDto(employeeDto, departmentDto);
    }

    public EmployeeResponseDto getDefaultDepartment(Long employeeId, Throwable throwable) {
        LOGGER.info("Inside Get Default Department");
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        DepartmentDto departmentDto = new DepartmentDto();

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
