package com.alexdev.bankapp.user.domain;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.user.infraestructure.UserRepository;

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
    public User getUser(Long id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new UserNotFoundException("User not found with id " + id);
        }
    }
    

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    public class UserNotFoundException extends Exception {
        public UserNotFoundException(String errorMessage) {
            super(errorMessage);
        }
    }

}