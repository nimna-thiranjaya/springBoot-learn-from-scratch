package com.nimnadev.employee_service.controller;

import com.nimnadev.employee_service.dto.EmployeeDto;
import com.nimnadev.employee_service.dto.EmployeeResponseDto;
import com.nimnadev.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {
        EmployeeResponseDto employeeDto = employeeService.getEmployee(employeeId);
        return new ResponseEntity<EmployeeResponseDto>(employeeDto, HttpStatus.OK);
    }
}
