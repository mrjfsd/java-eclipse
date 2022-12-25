package com.example.emp.controller;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.entity.User;
//import com.example.emp.exception.ResourceNotFoundException;
import com.example.emp.repository.UserRepository;


@RestController
@RequestMapping("/users")
public class Usercontroller {
	 @Autowired
	 UserRepository trepo;
	 
	 @PostMapping("/addtemp")
	 public String addtemp(@RequestBody User tmodel) {
		 trepo.save(tmodel);
		 return "Employee added" +tmodel.getId();
	 }
	 
	 @GetMapping("/display")
	 public List<User> display(){
		 return (List<User>) trepo.findAll();
	 }
	 @DeleteMapping("/delete/{id}")
	 public String delete(@PathVariable Long id) {
		 trepo.deleteById(id);
		 return "Employee deleted"+id;
	 }
	 
		@RequestMapping("/upt/{id}")
		public String upt(@RequestBody User tmodel)
		{	
			User exist=trepo.findById((long) tmodel.getId()).get();
			exist.setName(tmodel.getName());
			
			trepo.save(exist);
			return "Record updated by"+tmodel.getId();
		}
}
