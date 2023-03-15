package com.alexdev.bankapp.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import com.alexdev.bankapp.entities.Transfer;

public interface TransferRepository extends CrudRepository<Transfer, Long> {
    
    public ArrayList<Transfer> findAll();
    public Transfer findById(long id);
    public Transfer save(Transfer transfer);
}