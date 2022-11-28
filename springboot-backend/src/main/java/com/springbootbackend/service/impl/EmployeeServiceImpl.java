package com.springbootbackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootbackend.entity.Employee;
import com.springbootbackend.exception.ResourceNotFoundException;
import com.springbootbackend.repository.EmployeeRepository;
import com.springbootbackend.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}


	@Override
	public Employee getEmployeeById(long id) {
		// TODO Auto-generated method stub
//		Optional<Employee> optional=employeeRepository.findById(id);
//		if(optional.isPresent()) {
//			Employee employee=optional.get();
//			return employee;			
//		}else {
//			throw new ResourceNotFoundException("Employee","id",id);
//		}
		
		return employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee","id",id));

	}


	@Override
	public Employee updateEmployeeById(Employee employee,long id) {
		// TODO Auto-generated method stub
//		Employee emp=employeeRepository.findById(id).orElseThrow(
//				()->new ResourceNotFoundException("Employee","Id",id));
//			
//			emp.setFirstName(employee.getFirstName());
//			emp.setLastName(employee.getLastName());
//			emp.setEmail(employee.getEmail());
//			employeeRepository.save(emp);
//			return emp;
		
		Optional<Employee> optional=employeeRepository.findById(id);
		if(optional.isPresent()) {
			Employee emp=optional.get();
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmail(employee.getEmail());
			
			employeeRepository.save(emp);
			return emp;
		}else {
			throw new ResourceNotFoundException("Employee","Id",id);
		}
	}


	@Override
	public void deleteEmployee(long id) {
		
		employeeRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("Employee","Id",id));
		employeeRepository.deleteById(id);
		
	}
	
}
