package com.nimnadev.department_service.service;

import com.nimnadev.department_service.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    
    DepartmentDto getDepartmentById(Long departmentId);

    DepartmentDto getDepartmentByCode(String departmentCode);
    
} 