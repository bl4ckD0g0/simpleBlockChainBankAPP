package com.alexdev.bankapp.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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

    @Column(name ="ID_ORIGIN_ACCOUNT")
    private long originAccount;

    @Column(name ="ID_DESTINY_ACCOUNT")
    private long destinyAccount;

    @Column(name ="AMOUNT")
    private BigDecimal amount;

    @Column(name ="TRANSFERDATE")
    private LocalDateTime transferDate;
}