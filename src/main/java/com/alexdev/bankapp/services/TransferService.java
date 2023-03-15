package com.alexdev.bankapp.services;

import java.util.List;

import com.alexdev.bankapp.entities.Transfer;

public interface TransferService {

    List<Transfer> getTransfers();
    
    Transfer getTransfer(Long id);

    void createTransfer(Transfer transfer);
}