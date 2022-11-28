package com.springbootbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootbackend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
