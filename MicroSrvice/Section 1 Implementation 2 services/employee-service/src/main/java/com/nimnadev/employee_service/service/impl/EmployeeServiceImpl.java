package com.nimnadev.employee_service.service.impl;

import com.nimnadev.employee_service.dto.EmployeeDto;
import com.nimnadev.employee_service.entity.Employee;
import com.nimnadev.employee_service.repository.EmployeeRepository;
import com.nimnadev.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = new EmployeeDto(
                savedEmployee.getId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getEmail()
        );

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));

        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
