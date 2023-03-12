package com.alexdev.bankapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.entities.User;
import com.alexdev.bankapp.repositories.UserRepository;

import java.util.List;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent())
            return optionalUser.get();
        return null;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

}