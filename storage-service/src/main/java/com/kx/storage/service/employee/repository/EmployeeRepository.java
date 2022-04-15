package com.kx.storage.service.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kx.storage.service.employee.model.EmployeeModel;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeModel, String> {

}