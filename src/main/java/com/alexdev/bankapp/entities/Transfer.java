package com.alexdev.bankapp.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "TRANSFER")
@AllArgsConstructor
@NoArgsConstructor
public class Transfer extends Deposit {
    
    @Column(name ="ID_ORIGIN_ACCOUNT")
    private long originAccount;
}