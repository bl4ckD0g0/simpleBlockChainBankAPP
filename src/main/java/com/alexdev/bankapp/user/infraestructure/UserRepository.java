package com.alexdev.bankapp.user.infraestructure;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.alexdev.bankapp.user.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    public ArrayList<User> findAll();
    public Optional<User> findById(long id);
    public User save(User user);
}
