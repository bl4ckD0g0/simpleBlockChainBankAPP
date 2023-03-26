package com.alexdev.bankapp.deposit.domain;
import java.util.List;

public interface DepositService {
    List<Deposit> getDeposits();
    
    Deposit getDeposit(Long id);

    void createDeposit(Deposit transfer);
}