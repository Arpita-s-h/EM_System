package com.demo.Employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name="Employee")
	public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name= "firstName")
		private String firstName;
		@Column(name= "lastName")
		private String lastName;
		@Column(name= "salary")
		private Long salary;
		
		
		public Employee() {
			
		}
		public Employee(int id, String firstName, String lastName, Long salary) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.salary = salary;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public Long getSalary() {
			return salary;
		}
		public void setSalary(Long salary) {
			this.salary = salary;
		}
		
		

	}

