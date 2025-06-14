package com.nimnadev.employee_service.service;

import com.nimnadev.employee_service.dto.EmployeeDto;
import com.nimnadev.employee_service.dto.EmployeeResponseDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeResponseDto getEmployee(Long employeeId);
}
