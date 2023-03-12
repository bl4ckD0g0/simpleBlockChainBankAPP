package com.alexdev.bankapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alexdev.bankapp.services.UserServiceImpl;

@Configuration
public class BeanConfiguration {
    
    @Bean
    public UserServiceImpl getUserServiceImpls(){
        return new UserServiceImpl();
    }
}
