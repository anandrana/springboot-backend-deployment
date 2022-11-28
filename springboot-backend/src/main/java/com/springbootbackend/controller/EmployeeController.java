package com.springbootbackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootbackend.entity.Employee;
import com.springbootbackend.service.EmployeeService;

@RestController
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/api/employees")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	@GetMapping("/api/allEmployees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/api/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
	@PutMapping("/api/employee/{id}")
	public ResponseEntity<Employee> updateEmployeeById(@RequestBody Employee employee,@PathVariable long id){
		return new ResponseEntity<Employee>(employeeService.updateEmployeeById(employee, id),HttpStatus.OK);
	}
	
	@DeleteMapping("/api/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("delete the employee from the table",HttpStatus.OK);
	}
}
