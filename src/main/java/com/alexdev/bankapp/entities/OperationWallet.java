package com.alexdev.bankapp.entities;

import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import lombok.Data;

@Data
public abstract class OperationWallet {
    
    @Id
    @Column(name ="ID")
    @GeneratedValue
    private long id;

    @Column(name ="ID_DESTINY_ACCOUNT")
    private long destinyAccount;

    @Column(name ="AMOUNT")
    private BigDecimal amount;

    @Column(name ="TRANSFERDATE")
    private LocalDateTime transferDate;

}