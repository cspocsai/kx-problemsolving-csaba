package com.kx.storage.service.employee.controller;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kx.storage.service.employee.controller.EmployeeController;
import com.kx.storage.service.employee.model.dto.Employee;
import com.kx.storage.service.employee.service.EmployeeService;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmployeeService employeeService;

	@BeforeEach
	public void setup() {
		// MockMvc standalone approach
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}

	@Test
	//@Disabled
	void testEmployeeEndpointInvocation() throws Exception {

		final List<Employee> employees = getEmployees();
		when(employeeService.getAll()).thenReturn(employees);

		mockMvc.perform(get("/employee/all")).andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))

				.andExpect(jsonPath("$[0].name", is(employees.get(0).getName())))
				.andExpect(jsonPath("$[0].address", is(employees.get(0).getAddress())))
				.andExpect(jsonPath("$[0].sex", is(employees.get(0).getSex())))
				.andExpect(jsonPath("$[0].phoneNumber", is(employees.get(0).getPhoneNumber())))
				.andExpect(jsonPath("$[0].position", is(employees.get(0).getPosition())))
				.andExpect(jsonPath("$[0].title", is(employees.get(0).getTitle())))

				.andExpect(jsonPath("$[1].name", is(employees.get(1).getName())))
				.andExpect(jsonPath("$[1]address", is(employees.get(1).getAddress())))
				.andExpect(jsonPath("$[1].sex", is(employees.get(1).getSex())))
				.andExpect(jsonPath("$[1].phoneNumber", is(employees.get(1).getPhoneNumber())))
				.andExpect(jsonPath("$[1].position", is(employees.get(1).getPosition())))
				.andExpect(jsonPath("$[1].title", is(employees.get(1).getTitle())));

	}

	private List<Employee> getEmployees() {

		final Employee employee1 = Employee.builder()
				.name("Judson Schroeder")
				.address("587 Dominic Terrace")
				.sex("Female")
				.phoneNumber("(959) 887-0198")
				.position("Designer")
				.title("Lead Consulting Specialist")
				.build();

		final Employee employee2 = Employee.builder()
				.name("Orval Windler")
				.address("978 Schowalter Motorway")
				.sex("Female")
				.phoneNumber("012-495-1251 x572")
				.position("Consultant")
				.title("Customer Specialist")
				.build();

		return List.of(employee1, employee2);
	}
}