package com.alexdev.bankapp.wallet.domain;

import java.util.List;

import com.alexdev.bankapp.wallet.domain.WalletServiceImpl.UserNotFoundException;

public interface WalletService {

    public List<Wallet> getWallets();

    public Wallet getWallet(Long id);

    public void createWallet(Wallet wallet) throws UserNotFoundException;
}