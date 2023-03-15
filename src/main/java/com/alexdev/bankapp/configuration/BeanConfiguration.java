package com.alexdev.bankapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alexdev.bankapp.services.TransferServiceImpl;
import com.alexdev.bankapp.services.UserServiceImpl;
import com.alexdev.bankapp.services.WalletServiceImpl;

@Configuration
public class BeanConfiguration {
    
    @Bean
    public UserServiceImpl getUserServiceImpls(){
        return new UserServiceImpl();
    }

    @Bean
    public WalletServiceImpl getWalletServiceImpl(){
        return new WalletServiceImpl();
    }

    @Bean
    public TransferServiceImpl getTransferServiceImpl(){
        return new TransferServiceImpl();
    }

}