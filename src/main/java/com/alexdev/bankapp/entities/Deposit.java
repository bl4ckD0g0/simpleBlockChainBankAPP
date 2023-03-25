package com.alexdev.bankapp.entities;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonBackReference;


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

    @ManyToOne
    @JsonBackReference
    private Wallet wallet;

    @Column(name ="AMOUNT")
    private BigDecimal amount;

    @Column(name ="TRANSFERDATE")
    private LocalDateTime Date;

}
