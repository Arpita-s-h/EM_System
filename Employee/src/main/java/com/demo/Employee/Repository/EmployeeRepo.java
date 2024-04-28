package com.demo.Employee.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Employee.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	

}
