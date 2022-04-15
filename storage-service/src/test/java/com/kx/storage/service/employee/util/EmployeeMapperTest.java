package com.kx.storage.service.employee.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kx.storage.service.employee.model.EmployeeModel;
import com.kx.storage.service.employee.model.dto.Employee;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class EmployeeMapperTest
{
    @Spy
    private EmployeeMapper employeeMapper;

    @Test
    void testToModelMapping() {
        final Employee employee = Employee.builder()
                .name("Rachel Bayer")
                .address("11995 Christiansen Shoal")
                .sex("Male")
                .phoneNumber("(921) 623-3388 x21896")
                .position("Engineer")
                .title("Central Hospitality Executive")
                .build();

        final EmployeeModel employeeModel = employeeMapper.toModel(employee);

        assertEquals(employee.getName(), employeeModel.getName());
        assertEquals(employee.getAddress(), employeeModel.getAddress());
        assertEquals(employee.getPosition(), employeeModel.getPosition());
        assertEquals(employee.getSex(), employeeModel.getSex());
        assertEquals(employee.getPhoneNumber(), employeeModel.getPhoneNumber());
        assertEquals(employee.getTitle(), employeeModel.getTitle());

        assertNotNull(employeeModel.getId());
        assertNotNull(employeeModel.getCreationDate());
    }

    @Test
    void testToDtpMapping() {
        final EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setName("Rachel Bayer");
        employeeModel.setAddress("11995 Christiansen Shoal");
        employeeModel.setSex("Male");
        employeeModel.setPhoneNumber("(921) 623-3388 x21896");
        employeeModel.setPosition("Engineer");
        employeeModel.setTitle("Central Hospitality Executive");

        final Employee employee = employeeMapper.toDto(employeeModel);

        assertEquals(employeeModel.getName(), employee.getName());
        assertEquals(employeeModel.getAddress(), employee.getAddress());
        assertEquals(employeeModel.getPosition(), employee.getPosition());
        assertEquals(employeeModel.getSex(), employee.getSex());
        assertEquals(employeeModel.getPhoneNumber(), employee.getPhoneNumber());
        assertEquals(employeeModel.getTitle(), employee.getTitle());
    }
}
