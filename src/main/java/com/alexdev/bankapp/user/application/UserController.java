package com.alexdev.bankapp.user.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexdev.bankapp.user.domain.User;
import com.alexdev.bankapp.user.domain.UserService;
import com.alexdev.bankapp.user.domain.UserServiceImpl.UserNotFoundException;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getUsers();
	}

	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) throws UserNotFoundException {
		return userService.getUser(id);
	}

	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

}