package com.alexdev.bankapp.deposit.infraestructure;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.alexdev.bankapp.deposit.domain.Deposit;

public interface DepositRepository extends CrudRepository<Deposit, Long>{
    
    public ArrayList<Deposit> findAll();
    public Deposit findById(long id);
    public Deposit save(Deposit deposit);
}
