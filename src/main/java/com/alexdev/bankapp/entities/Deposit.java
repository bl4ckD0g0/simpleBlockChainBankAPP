package com.alexdev.bankapp.entities;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "DEPOSIT")
@AllArgsConstructor
@NoArgsConstructor
public class Deposit {
    
    @Id
    @Column(name ="ID")
    @GeneratedValue
    private long id;

    @Column(name ="ID_DESTINY_ACCOUNT")
    @JoinColumn(name = "id")
    private long account;

    @Column(name ="AMOUNT")
    private BigDecimal amount;

    @Column(name ="TRANSFERDATE")
    private LocalDateTime transferDate;

}