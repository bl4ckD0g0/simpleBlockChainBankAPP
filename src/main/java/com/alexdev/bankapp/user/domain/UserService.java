

package com.alexdev.bankapp.user.domain;

import java.util.List;

public interface UserService {

    public List<User> getUsers();

    public User getUser(Long id);

    public void createUser(User user);
}