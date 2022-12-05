package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	// This will be AUTO IMPLEMENTED by Spring into a Bean
	boolean existsById(Long id);
}