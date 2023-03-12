package com.alexdev.bankapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name ="WALLET")
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {
    
    @Id
    @Column(name ="ID")
    @GeneratedValue
    private long id;

    @Column(name ="ACCOUNT_BALANCE")
    private String accountBalance;

    @Column(name ="ID_USER_PROPIETARY")
    private long walletPropietary;
}