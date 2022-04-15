package com.kx.storage.service.employee.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kx.storage.service.employee.model.EmployeeModel;
import com.kx.storage.service.employee.model.dto.Employee;
import com.kx.storage.service.employee.repository.EmployeeRepository;
import com.kx.storage.service.employee.util.EmployeeMapper;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService employeeService;

    @Spy
    private EmployeeMapper employeeMapper;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void testGetEmployees() {
        final List<EmployeeModel> employeeModels = getEmployees();
        when(employeeRepository.findAll()).thenReturn(employeeModels);
        final List<Employee> allEmployees = employeeService.getAll();
        assertEquals(1, allEmployees.size());
        assertEquals(employeeModels.get(0).getName(), allEmployees.get(0).getName());
        assertEquals(employeeModels.get(0).getAddress(), allEmployees.get(0).getAddress());
        assertEquals(employeeModels.get(0).getPosition(), allEmployees.get(0).getPosition());
        assertEquals(employeeModels.get(0).getSex(), allEmployees.get(0).getSex());
        assertEquals(employeeModels.get(0).getTitle(), allEmployees.get(0).getTitle());

    }

    private List<EmployeeModel> getEmployees() {
        final EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setName("Josue Auer");
        employeeModel.setAddress("1651 Anton Trail");
        employeeModel.setSex("Male");
        employeeModel.setPhoneNumber("(805) 535-0891");
        employeeModel.setPosition("Officer");
        employeeModel.setTitle("Regional Consulting Executive");
        return Collections.singletonList(employeeModel);
    }
}
