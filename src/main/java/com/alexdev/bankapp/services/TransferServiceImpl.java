package com.alexdev.bankapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alexdev.bankapp.entities.Transfer;
import com.alexdev.bankapp.repositories.TransferRepository;
import com.alexdev.bankapp.repositories.WalletRepository;

import java.util.Optional;

public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public List<Transfer> getTransfers() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer getTransfer(Long id) {
        Optional<Transfer> optionalTransfer = transferRepository.findById(id);
        if (optionalTransfer.isPresent())
            return optionalTransfer.get();
        return null;
    }

    @Override
    public void createTransfer(Transfer transfer) {
        //#TODO: UPDATE WALLETS
        transferRepository.save(transfer);
    }

}