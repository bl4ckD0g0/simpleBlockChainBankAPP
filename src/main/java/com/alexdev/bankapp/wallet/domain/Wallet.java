package com.alexdev.bankapp.wallet.domain;

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

import com.alexdev.bankapp.deposit.domain.Deposit;
import com.alexdev.bankapp.transfer.domain.Transfer;
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

    @JsonManagedReference(value="origin-wallet")
    @OneToMany(mappedBy="originWallet")
    private List<Transfer> transferHistorySends;

    @JsonManagedReference(value="destiny-wallet")
    @OneToMany(mappedBy="destinyWallet")
    private List<Transfer> transferHistoryReceivs;
    
    @JsonManagedReference(value="wallet-deposit")
    @OneToMany(mappedBy="wallet")
    private List<Deposit> depositHistory;
}