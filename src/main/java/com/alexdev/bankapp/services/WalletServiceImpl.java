package com.alexdev.bankapp.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.entities.Wallet;
import com.alexdev.bankapp.repositories.UserRepository;
import com.alexdev.bankapp.repositories.WalletRepository;

import java.util.List;
import java.util.Objects;


public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private UserRepository userRepository;

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
        if(Objects.nonNull(userRepository.findById(wallet.getWalletPropietary())))
            walletRepository.save(wallet);
        else
            System.out.println("There is no user with the provided ID"); //TODO: Send info to the input
    }


    @Override
    public void depositMoney(Long walletId, Float amount) {

        Wallet modifiedWallet, originalWallet; 
        modifiedWallet = originalWallet = walletRepository.findById(walletId).get();

        modifiedWallet.setAccountBalance(originalWallet.getAccountBalance() + amount);

        walletRepository.delete(originalWallet);
        walletRepository.save(modifiedWallet);
    }

    

    //TODO: Check if the wallet exists
    //TODO: The User should be the owner of the Wallet.

}