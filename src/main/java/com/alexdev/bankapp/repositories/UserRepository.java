package com.alexdev.bankapp.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.alexdev.bankapp.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

    public ArrayList<User> findAll();
    public Optional<User> findById(long id);
    public User save(User user);
}
