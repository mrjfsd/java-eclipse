package com.example.demo;

import javax.persistence.Entity;

import javax.persistence.Id; 
@Entity // This tells Hibernate to create a table of this class
public class Employee { 
	@Id 
	private long id;
	private String name;
	private String department;
	private float salary; 

	public Employee() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	} 

}