package com.alexdev.bankapp.services;

import java.util.List;

import com.alexdev.bankapp.entities.Wallet;

public interface WalletService {

    public List<Wallet> getWallets();

    public Wallet getWallet(Long id);

    public void createWallet(Wallet wallet);

    public void depositMoney(Long walletId, Float amount);

    
}
