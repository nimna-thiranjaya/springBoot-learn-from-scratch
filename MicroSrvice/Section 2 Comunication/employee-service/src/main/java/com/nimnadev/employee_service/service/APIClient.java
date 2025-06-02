package com.nimnadev.employee_service.service;

import com.nimnadev.employee_service.dto.DepartmentDto;
import com.nimnadev.employee_service.dto.EmployeeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/getByCode/{departmentCode}")
    DepartmentDto getDepartmentByCode(@PathVariable("departmentCode") String departmentCode);
}
