package com.alexdev.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alexdev.bankapp.entities.Wallet;
import com.alexdev.bankapp.services.WalletService;
import com.alexdev.bankapp.services.WalletServiceImpl.UserNotFoundException;

import java.util.List;

@RestController
public class WalletController {

	@Autowired
	private WalletService walletService;

	@GetMapping("/wallets")
	public List<Wallet> getAllWallets() {
		return walletService.getWallets();
	}

	@GetMapping("/wallets/{id}")
	public Wallet getWallet(@PathVariable Long id) {
		return walletService.getWallet(id);
	}

	@PostMapping("/wallets")
	public void createWallet(@RequestBody Wallet wallet) throws UserNotFoundException {
		walletService.createWallet(wallet);
	}
}