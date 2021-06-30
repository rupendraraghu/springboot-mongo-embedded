package com.rup.mongodb.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rup.mongodb.api.model.User;
import com.rup.mongodb.api.repository.FlipkartRepository;

@RestController
@RequestMapping("orderservice")
public class FilpkartController {
	@Autowired
	private FlipkartRepository repository;
	
	@PostMapping("/placeOrder")
	public String placeOrder(@RequestBody User user) {
		repository.save(user);
		return "Order placed successfully!";
	}

	@GetMapping("/getUserByName/{name}")
	public List<User> getUserByName(@PathVariable String name){
		return repository.findByName(name);
		
	}
	
	@GetMapping("/getUserByCity/{city}")
	public List<User> getUserByCity(@PathVariable String city){
		return repository.findByCity(city);
		
	}
}
