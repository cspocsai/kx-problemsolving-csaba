package com.kx.storage.service.employee.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kx.storage.service.employee.model.dto.Employee;
import com.kx.storage.service.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
 
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }
}