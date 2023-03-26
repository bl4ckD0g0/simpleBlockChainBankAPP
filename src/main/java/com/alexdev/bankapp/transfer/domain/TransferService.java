package com.alexdev.bankapp.transfer.domain;

import java.util.List;

public interface TransferService {

    List<Transfer> getTransfers();
    
    Transfer getTransfer(Long id);

    void createTransfer(Transfer transfer);
}