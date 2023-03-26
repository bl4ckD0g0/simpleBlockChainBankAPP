package com.alexdev.bankapp.transfer.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.transfer.infraestructure.TransferRepository;
import com.alexdev.bankapp.wallet.domain.Wallet;
import com.alexdev.bankapp.wallet.infraestructure.WalletRepository;

import jakarta.transaction.Transactional;

public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<Transfer> getTransfers() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer getTransfer(Long id) {
        Optional<Transfer> optionalTransfer = transferRepository.findById(id);
        if (optionalTransfer.isPresent())
            return optionalTransfer.get();
        return null;
    }

    @Override
    @Transactional
    public void createTransfer(Transfer transfer) {
        Wallet originWallet = walletRepository.findById(transfer.getOriginWallet().getId());
        Wallet destinyWallet = walletRepository.findById(transfer.getDestinyWallet().getId());
        BigDecimal amount = transfer.getAmount();
        
        if (originWallet.getAccountBalance().compareTo(amount) < 0)
            throw new InsufficientFundsException("Insufficient balance in the source account");
    
        originWallet.setAccountBalance(originWallet.getAccountBalance().subtract(amount));
        destinyWallet.setAccountBalance(destinyWallet.getAccountBalance().add(amount));
     
        transfer.setDate(LocalDateTime.now());
        transferRepository.save(transfer);
    }

    public class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
}