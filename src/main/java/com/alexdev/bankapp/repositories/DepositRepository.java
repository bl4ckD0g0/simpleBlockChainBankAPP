package com.alexdev.bankapp.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import com.alexdev.bankapp.entities.Deposit;

public interface DepositRepository extends CrudRepository<Deposit, Long>{
    
    public ArrayList<Deposit> findAll();
    public Deposit findById(long id);
    public Deposit save(Deposit deposit);
}
