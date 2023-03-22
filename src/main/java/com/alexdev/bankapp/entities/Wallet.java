package com.alexdev.bankapp.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    private BigDecimal accountBalance;

    @Column(name ="ID_USER_PROPIETARY")
    private long walletPropietary;

    @Column(name ="MOVEMENTS")
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Deposit> bankMovements;
}