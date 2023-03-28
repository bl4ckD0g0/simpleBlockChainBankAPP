package com.alexdev.bankapp.wallet.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alexdev.bankapp.wallet.domain.Wallet;
import com.alexdev.bankapp.wallet.domain.WalletService;
import com.alexdev.bankapp.wallet.domain.WalletServiceImpl.UserNotFoundException;

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
		if(walletService == null)
		System.out.println("aja");
	  else
		  System.out.println("no aja");
		walletService.createWallet(wallet);
	}
}