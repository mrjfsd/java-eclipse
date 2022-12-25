package com.example.test4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.test4.model.Tmodel;
import com.example.test4.repository.Trepository;
@RestController
public class Tcontroller {


 @Autowired
 Trepository trepo;
 
 @PostMapping("/addtemp")
 public String addtemp(@RequestBody Tmodel tmodel) {
	 trepo.save(tmodel);
	 return "Employee added" +tmodel.getId();
 }
 
 @GetMapping("/display")
 public List<Tmodel> display(){
	 return trepo.findAll();
 }
 @DeleteMapping("/delete/{id}")
 public String delete(@PathVariable int id) {
	 trepo.deleteById(id);
	 return "Employee deleted"+id;
 }
 
	@RequestMapping("/upt/{id}")
	public String upt(@RequestBody Tmodel tmodel)
	{	
		Tmodel exist=trepo.findById(tmodel.getId()).get();
		exist.setName(tmodel.getName());
		trepo.save(exist);
		return "Record updated by"+tmodel.getId();
	}
	

}
