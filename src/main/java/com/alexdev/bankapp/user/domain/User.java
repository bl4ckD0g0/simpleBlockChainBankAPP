package com.alexdev.bankapp.user.domain;

import java.util.List;

import com.alexdev.bankapp.wallet.domain.Wallet;

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
@Table(name="USERS")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @Id
    @Column(name ="ID")
    @GeneratedValue
    private long id;

    @Column(name ="FULL_NAME")
    private String fullName;

    @Column(name ="ID_DOCUMENT")
    private String idDocument;

    @OneToMany
    private List<Wallet> walletList;
    
}