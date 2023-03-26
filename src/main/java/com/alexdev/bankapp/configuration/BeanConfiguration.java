package com.alexdev.bankapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alexdev.bankapp.deposit.domain.DepositServiceImpl;
import com.alexdev.bankapp.transfer.domain.TransferServiceImpl;
import com.alexdev.bankapp.user.domain.UserServiceImpl;
import com.alexdev.bankapp.wallet.domain.WalletServiceImpl;

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

    @Bean
    public DepositServiceImpl getDepositServiceImpl(){
        return new DepositServiceImpl();
    }

}