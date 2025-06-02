package com.nimnadev.employee_service.service;

import com.nimnadev.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(Long employeeId);
}
