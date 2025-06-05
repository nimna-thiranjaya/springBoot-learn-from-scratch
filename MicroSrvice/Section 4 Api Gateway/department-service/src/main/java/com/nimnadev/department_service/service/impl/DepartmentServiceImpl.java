package com.nimnadev.department_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimnadev.department_service.dto.DepartmentDto;
import com.nimnadev.department_service.entity.Department;
import com.nimnadev.department_service.repository.DepartmentRepository;
import com.nimnadev.department_service.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = new Department(
            departmentDto.getId(),
            departmentDto.getDepartmentName(),
            departmentDto.getDepartmentDescription(),
            departmentDto.getDepartmentCode()
        );

        Department savedDepartment = departmentRepository.save(department);

        return new DepartmentDto(
            savedDepartment.getId(),
            savedDepartment.getDepartmentName(),
            savedDepartment.getDepartmentDescription(),
            savedDepartment.getDepartmentCode()
        );
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found with id: " + departmentId));
            
        return new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
            department.getDepartmentDescription(),
            department.getDepartmentCode()
        );
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        
        return new DepartmentDto(
            department.getId(),
            department.getDepartmentName(),
            department.getDepartmentDescription(),
            department.getDepartmentCode()
        );
    }
}
