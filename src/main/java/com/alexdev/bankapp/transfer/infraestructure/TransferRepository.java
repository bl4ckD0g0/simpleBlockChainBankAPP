package com.alexdev.bankapp.transfer.infraestructure;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.alexdev.bankapp.transfer.domain.Transfer;

public interface TransferRepository extends CrudRepository<Transfer, Long> {
    
    public ArrayList<Transfer> findAll();
    public Transfer findById(long id);
    public Transfer save(Transfer transfer);
}