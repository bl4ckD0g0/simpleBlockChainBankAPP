package com.alexdev.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexdev.bankapp.entities.User;
import com.alexdev.bankapp.services.UserService;

import java.util.List;


@RestController
public class UsersController {

    @Autowired
    private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}


	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

}