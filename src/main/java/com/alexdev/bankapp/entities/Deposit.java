package com.alexdev.bankapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "DEPOSIT")
public class Deposit extends OperationWallet {
}
