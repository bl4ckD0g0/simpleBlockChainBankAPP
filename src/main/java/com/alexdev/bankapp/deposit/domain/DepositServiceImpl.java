package com.alexdev.bankapp.deposit.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.deposit.infraestructure.DepositRepository;
import com.alexdev.bankapp.wallet.domain.Wallet;
import com.alexdev.bankapp.wallet.infraestructure.WalletRepository;

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
        Wallet wallet = walletRepository.findById(deposit.getWallet().getId());
                
        BigDecimal amount = deposit.getAmount();
        
        wallet.setAccountBalance(wallet.getAccountBalance().add(amount));

        deposit.setDate(LocalDateTime.now());
        depositRepository.save(deposit);
    }
}
