package com.alexdev.bankapp.repositories;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import com.alexdev.bankapp.entities.Wallet;

public interface WalletRepository extends CrudRepository<Wallet, Long> {

    public ArrayList<Wallet> findAll();
    public Wallet findById(long id);
    public Wallet save(Wallet user);
}
