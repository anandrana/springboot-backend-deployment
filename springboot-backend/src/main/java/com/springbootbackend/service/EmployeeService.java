package com.springbootbackend.service;

import java.util.List;

import com.springbootbackend.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployeeById(Employee employee,long id);
	
	void deleteEmployee(long id);
}
