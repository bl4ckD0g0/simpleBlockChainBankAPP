package com.alexdev.bankapp.services;
import java.util.List;

import com.alexdev.bankapp.entities.Deposit;

public interface DepositService {
    List<Deposit> getDeposits();
    
    Deposit getDeposit(Long id);

    void createDeposit(Deposit transfer);
}
