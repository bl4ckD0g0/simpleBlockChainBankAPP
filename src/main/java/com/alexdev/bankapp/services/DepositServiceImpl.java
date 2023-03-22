package com.alexdev.bankapp.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.entities.Deposit;
import com.alexdev.bankapp.entities.Wallet;
import com.alexdev.bankapp.repositories.DepositRepository;
import com.alexdev.bankapp.repositories.WalletRepository;

public class DepositServiceImpl implements DepositService {

    @Autowired
    private DepositRepository depositRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<Deposit> getDeposits() {
        return depositRepository.findAll();
    }

    @Override
    public Deposit getDeposit(Long id) {
        Optional<Deposit> optionalDeposit = depositRepository.findById(id);
        if (optionalDeposit.isPresent())
            return optionalDeposit.get();
        return null;
    }

    @Override
    public void createDeposit(Deposit deposit) {
        Wallet destinyWallet = walletRepository.findById(deposit.getDestinyAccount());
        BigDecimal amount = deposit.getAmount();
        
        destinyWallet.setAccountBalance(destinyWallet.getAccountBalance().add(amount));
     
        List<Deposit> bankMovements = destinyWallet.getBankMovements();  
        bankMovements.add(deposit);
        destinyWallet.setBankMovements(bankMovements);

        walletRepository.save(destinyWallet);
        depositRepository.save(deposit);
    }

}
