package com.nimnadev.employee_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
    private EmployeeDto employee;
    private DepartmentDto department;
}
