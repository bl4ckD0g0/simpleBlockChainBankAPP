package com.alexdev.bankapp.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    private BigDecimal accountBalance;

    @Column(name ="ID_USER_PROPIETARY")
    private long walletPropietary;

    @JsonManagedReference
    @OneToMany(mappedBy="originWallet")
    private List<Transfer> transferHistorySends;

    @JsonManagedReference
    @OneToMany(mappedBy="destinyWallet")
    private List<Transfer> transferHistoryReceivs;
    
    @JsonManagedReference("wallet-deposit")
    @OneToMany(mappedBy="wallet")
    private List<Deposit> depositHistory;
}
