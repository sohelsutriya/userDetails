/*
 * 
 * @Author: Simran
 */
package com.cg.obs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.obs.model.User;
import com.cg.obs.service.UserService;

@RestController
public class UserController {
	@Autowired
	public UserService service;

	@GetMapping(path = "/User")
	public List<User> retrieveAllUsers() {
		System.out.println("Inside retrieveAllUsers method of UserController");
		return service.findAll();
	}

	@PostMapping(path = "/User/add")
	User addUser(@RequestBody User user) {
		return service.addUser(user);
	}

	@GetMapping(path = "/User/{userId}")
	User retrieveByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);
	}
	
	@DeleteMapping(path = "/User/delete/{userId}")	
	void deleteUser(@PathVariable("userId") int accNumber) {
		service.deleteUser(accNumber);
	}
	
	@PutMapping(path = "/User/updatemob/accnumber/{userId}/mobileno/{mobile}")
	public User updateMobileNo(@PathVariable("userId") int userId, @PathVariable("mobile") String mobile) {
		User user = service.updateMobile(userId, mobile);
		return user;
	}
	
	@PutMapping(path = "/User/updateaddress/accnumber/{userId}/address/{address}")
	public User updateAddress(@PathVariable("userId") int userId, @PathVariable("address") String address) {
		User user = service.updateAddress(userId, address);
		return user;
	}
	@PutMapping(path = "/User/update")
	public String updateUser(@RequestBody User user) {
		service.updateUser(user);
		return "User updated";
	}
	
}
	