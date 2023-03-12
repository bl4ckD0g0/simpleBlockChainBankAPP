package com.alexdev.bankapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.entities.User;
import com.alexdev.bankapp.repositories.UserRepository;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }


}