package com.kx.storage.service.employee.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.kx.storage.service.employee.model.dto.Employee;
import com.kx.storage.service.employee.repository.EmployeeRepository;
import com.kx.storage.service.employee.util.EmployeeMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<Employee> getAll() {
        return StreamSupport.stream(employeeRepository.findAll().spliterator(), true)
                .map(employeeMapper::toDto).collect(Collectors.toList());
    }
}
