package com.alexdev.bankapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alexdev.bankapp.entities.Transfer;
import com.alexdev.bankapp.services.TransferService;

@RestController
public class TransferController {

	@Autowired
	private TransferService  transferService;

	@GetMapping("/transfers")
	public List<Transfer> getAllTranfers() {
		return transferService.getTransfers();
	}

	@GetMapping("/transfers/{id}")
	public Transfer getTransfer(@PathVariable Long id) {
		return transferService.getTransfer(id);
	}

	@PostMapping("/transfers")
	public void createTransfer(@RequestBody Transfer transfer) {
		transferService.createTransfer(transfer);
	}

}