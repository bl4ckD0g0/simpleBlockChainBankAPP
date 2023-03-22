package com.alexdev.bankapp.services;

import java.util.List;

import com.alexdev.bankapp.entities.Wallet;
import com.alexdev.bankapp.services.WalletServiceImpl.UserNotFoundException;

public interface WalletService {

    public List<Wallet> getWallets();

    public Wallet getWallet(Long id);

    public void createWallet(Wallet wallet) throws UserNotFoundException;
}