package com.alexdev.bankapp.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "TRANSFER")
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {
    
    @Id
    @Column(name ="ID")
    @GeneratedValue
    private long id;
    
    @ManyToOne
    @JsonBackReference("origin-wallet")
    private Wallet originWallet;

    @ManyToOne
    @JsonBackReference("destiny-wallet")
    private Wallet destinyWallet;

    @Column(name ="AMOUNT")
    private BigDecimal amount;

    @Column(name ="TRANSFERDATE")
    private LocalDateTime Date;
}