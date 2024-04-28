package com.demo.Employee.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Employee.Repository.EmployeeRepo;
import com.demo.Employee.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
		@Autowired
	 EmployeeRepo employeeRepo;
		
		@PostMapping("/employees")
		public String createNewEmployee(@RequestBody Employee employee) {
			employeeRepo.save(employee);
			return "Database created";		
		}
		@GetMapping("/employees")
		public ResponseEntity<List<Employee>>getEmployees() {
			List<Employee> empList = new ArrayList<Employee>();
			employeeRepo.findAll().forEach(empList::add);
			return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
			
		}
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employee>getEmployeesById(@PathVariable Integer id) {
			Optional<Employee> emp = employeeRepo.findById(id);
			
			if(emp.isPresent()) {
				return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
			}else{
				return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			}
		}
			@PutMapping("/employees/{id}")
			public String updateEmployeeById(@PathVariable Integer id, @RequestBody Employee employee) {
				Optional<Employee> emp = employeeRepo.findById(id);
				if(emp.isPresent()) {
					Employee existEmp = emp.get();
					existEmp.setFirstName(employee.getFirstName());
					existEmp.setLastName(employee.getLastName());
					existEmp.setSalary(employee.getSalary());
					employeeRepo.save(existEmp);
					return "Employee details against id " + id + " updated successfully ";
				}
				else {
					return "Employee details against id " + id + " doesn't exist ";
				}	
		}
			@DeleteMapping("/employees")
			public String deleteAllEmployees(Integer id) {
				employeeRepo.deleteAll();
				return "All Employees deleted successfully";
			}
			@DeleteMapping("/employees/{id}")
			public String deleteEmployeeById(@PathVariable Integer id) {
				employeeRepo.deleteById(id);
				return " Employee deleted successfully";
			}
}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
