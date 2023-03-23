package com.alexdev.bankapp.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.entities.Deposit;
import com.alexdev.bankapp.entities.Transfer;
import com.alexdev.bankapp.entities.Wallet;
import com.alexdev.bankapp.repositories.TransferRepository;
import com.alexdev.bankapp.repositories.WalletRepository;

import jakarta.transaction.Transactional;

import java.util.Optional;

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
        Wallet originWallet = walletRepository.findById(transfer.getOriginAccount());
        Wallet destinyWallet = walletRepository.findById(transfer.getDestinyAccount());
        BigDecimal amount = transfer.getAmount();
        
        if (originWallet.getAccountBalance().compareTo(amount) < 0)
            throw new InsufficientFundsException("Insufficient balance in the source account");
    
        originWallet.setAccountBalance(originWallet.getAccountBalance().subtract(amount));
        destinyWallet.setAccountBalance(destinyWallet.getAccountBalance().add(amount));
     
        transfer.setTransferDate(LocalDateTime.now());
        transferRepository.save(transfer);
    }

    public class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
    }
}