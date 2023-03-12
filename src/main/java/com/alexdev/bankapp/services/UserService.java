

package com.alexdev.bankapp.services;

import java.util.List;

import com.alexdev.bankapp.entities.User;

public interface UserService {

    public List<User> getUsers();

    public User getUser(Long id);

    public void createUser(User user);
}
