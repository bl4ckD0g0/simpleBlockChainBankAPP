package com.alexdev.bankapp.wallet.domain;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.user.domain.User;
import com.alexdev.bankapp.user.infraestructure.UserRepository;
import com.alexdev.bankapp.wallet.infraestructure.WalletRepository;

import java.util.List;
import java.util.Optional;


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
    public void createWallet(Wallet wallet) throws UserNotFoundException {

        Optional<User> user = userRepository.findById(wallet.getWalletPropietary());
        if(user == null)
            System.out.println("user es null");
        else
            System.out.println("user no es null");
        System.out.println(user);
        if(user.isPresent()) {
            walletRepository.save(wallet);
        } else {
            throw new UserNotFoundException("There is no user with the provided ID");
        }
    }

    public class UserNotFoundException extends Exception {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}