package com.alexdev.bankapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.alexdev.bankapp.entities.Wallet;
import com.alexdev.bankapp.services.WalletService;

import java.math.BigDecimal;
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
	public void createWallet(@RequestBody Wallet wallet) {
		walletService.createWallet(wallet);
	}

	@PutMapping(value = "/wallets/addMoney")
	public void depositMoney(@RequestParam("walletId") String walletId, @RequestParam("amount") String amount) {
		walletService.depositMoney(Long.parseLong(walletId), new BigDecimal(amount));
	}

}