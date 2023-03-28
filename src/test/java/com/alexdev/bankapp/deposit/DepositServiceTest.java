package com.alexdev.bankapp.deposit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.alexdev.bankapp.deposit.domain.Deposit;
import com.alexdev.bankapp.deposit.domain.DepositServiceImpl;
import com.alexdev.bankapp.deposit.infraestructure.DepositRepository;
import com.alexdev.bankapp.wallet.domain.Wallet;
import com.alexdev.bankapp.wallet.infraestructure.WalletRepository;

public class DepositServiceTest {

    @Mock
    private DepositRepository depositRepository;

    @Mock
    private WalletRepository walletRepository;

    @InjectMocks
    private DepositServiceImpl depositService;

    private Wallet wallet;
    private Deposit deposit;
    private List<Deposit> deposits;

    @BeforeEach
    public void setUp() {        
        wallet = new Wallet();
        wallet.setId(1L);
        wallet.setAccountBalance(BigDecimal.ZERO);
        
        deposit = new Deposit();
        deposit.setId(1L);
        deposit.setWallet(wallet);
        deposit.setAmount(new BigDecimal("100.00"));
        deposit.setDate(LocalDateTime.now());
        
        deposits = new ArrayList<>();
        deposits.add(deposit);
    }

    @Test
    public void testGetDeposits() {
        when(depositRepository.findAll()).thenReturn((ArrayList<Deposit>) deposits);
        
        List<Deposit> result = depositService.getDeposits();
        
        assertEquals(deposits, result);
    }

    @Test
    public void testGetDepositWhenExists() {
        when(depositRepository.findById(1L)).thenReturn(deposit);
        
        Deposit result = depositService.getDeposit(1L);
        
        assertEquals(deposit, result);
    }

    @Test
    public void testGetDepositWhenNotExists() {
        when(depositRepository.findById(2L)).thenReturn(null);
        
        Deposit result = depositService.getDeposit(2L);
        
        assertNull(result);
    }

    @Test
    public void testCreateDeposit() {
        when(walletRepository.findById(1L)).thenReturn(wallet);
        when(depositRepository.save(deposit)).thenReturn(deposit);
        
        Deposit newDeposit = new Deposit();
        newDeposit.setWallet(wallet);
        newDeposit.setAmount(new BigDecimal("50.00"));
        
        depositService.createDeposit(newDeposit);
        
        assertEquals(new BigDecimal("150.00"), wallet.getAccountBalance());
        assertNotNull(newDeposit.getDate());
        verify(depositRepository).save(newDeposit);
    }

}