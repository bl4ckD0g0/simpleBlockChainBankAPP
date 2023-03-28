

package com.alexdev.bankapp.user.domain;

import java.util.List;

import com.alexdev.bankapp.user.domain.UserServiceImpl.UserNotFoundException;

public interface UserService {

    public List<User> getUsers();

    public User getUser(Long id) throws UserNotFoundException;

    public void createUser(User user);
}