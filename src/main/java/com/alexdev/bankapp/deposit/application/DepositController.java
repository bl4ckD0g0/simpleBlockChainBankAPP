package com.alexdev.bankapp.deposit.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexdev.bankapp.deposit.domain.Deposit;
import com.alexdev.bankapp.deposit.domain.DepositService;

@RestController
public class DepositController {

	@Autowired
	private DepositService  depositService;

	@GetMapping("/deposits")
	public List<Deposit> getAllTranfers() {
		return depositService.getDeposits();
	}

	@GetMapping("/deposits/{id}")
	public Deposit getDeposit(@PathVariable Long id) {
		return depositService.getDeposit(id);
	}

	@PostMapping("/deposits")
	public void createDeposit(@RequestBody Deposit deposit) {
		depositService.createDeposit(deposit);
	}
}