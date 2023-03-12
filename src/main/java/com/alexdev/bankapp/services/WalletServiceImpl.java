package com.alexdev.bankapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.entities.Wallet;
import com.alexdev.bankapp.repositories.WalletRepository;

import java.util.List;


public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<Wallet> getWallets(){
        return walletRepository.findAll();
    }

    @Override
    public Wallet getWallet(Long id) {
        return walletRepository.findById(id).get();
    }

    @Override
    public void createWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }
    
}