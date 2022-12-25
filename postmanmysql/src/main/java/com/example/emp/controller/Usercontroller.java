package com.example.emp.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	private UserRepository userRepository;

	@GetMapping
	public List<User> getAllUser()
	{
		return this.userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value="id") long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow();

	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		userRepository.deleteById((long) id);
		return "deleted"+id;
	}
	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return this.userRepository.save(user);
	}
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") long userId)
	{
		//return this.userRepository.save(user);
		User ex=this.userRepository.findById(userId)
				.orElseThrow();
		ex.setFirstname(user.getFirstname());
		ex.setLasttname(user.getLasttname());
		return this.userRepository.save(ex);
	}
}
