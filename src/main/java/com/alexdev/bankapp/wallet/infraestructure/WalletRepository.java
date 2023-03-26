package com.alexdev.bankapp.wallet.infraestructure;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;

import com.alexdev.bankapp.wallet.domain.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Long> {

    public ArrayList<Wallet> findAll();
    public Wallet findById(long id);
    public Wallet save(Wallet user);
}
