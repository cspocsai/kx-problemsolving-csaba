package com.kx.storage.service.employee.util;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.kx.storage.service.employee.model.EmployeeModel;
import com.kx.storage.service.employee.model.dto.Employee;

@Component
public class EmployeeMapper {

    public EmployeeModel toModel(final Employee employee) {
        final EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(UUID.randomUUID().toString());
        employeeModel.setName(employee.getName());
        employeeModel.setAddress(employee.getAddress());
        employeeModel.setSex(employee.getSex());
        employeeModel.setTitle(employee.getTitle());
        employeeModel.setPosition(employee.getPosition());
        employeeModel.setPhoneNumber(employee.getPhoneNumber());
        employeeModel.setCreationDate(LocalDateTime.now());
        return employeeModel;
    }

    public Employee toDto(final EmployeeModel employeeModel) {
        return Employee.builder()
                .name(employeeModel.getName())
                .title(employeeModel.getTitle())
                .position(employeeModel.getPosition())
                .address(employeeModel.getAddress())
                .phoneNumber(employeeModel.getPhoneNumber())
                .sex(employeeModel.getSex())
                .build();
    }
}
