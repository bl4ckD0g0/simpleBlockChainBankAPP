package com.alexdev.bankapp.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alexdev.bankapp.wallet.application.WalletController;
import com.alexdev.bankapp.wallet.domain.Wallet;
import com.alexdev.bankapp.wallet.domain.WalletService;
import com.alexdev.bankapp.wallet.domain.WalletServiceImpl.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
public class WalletControllerTest {

    @Mock
    private WalletService walletService;

    @InjectMocks
    private WalletController walletController;

    private Wallet wallet1;
    private Wallet wallet2;

    @BeforeEach
    public void setUp() {
        wallet1 = new Wallet();
        wallet1.setId(1L);
        wallet1.setAccountBalance(new BigDecimal("1000.00"));
        wallet1.setWalletPropietary(1L);

        wallet2 = new Wallet();
        wallet2.setId(2L);
        wallet2.setAccountBalance(new BigDecimal("500.00"));
        wallet2.setWalletPropietary(2L);
    }

    @Test
    @DisplayName("Test get all wallets")
    public void testGetAllWallets() {
        List<Wallet> wallets = new ArrayList<>();
        wallets.add(wallet1);
        wallets.add(wallet2);
    
        when(walletService.getWallets()).thenReturn(wallets);
    
        List<Wallet> result = walletController.getAllWallets();
    
        assertEquals(2, result.size());
        assertEquals(wallet1.getAccountBalance(), result.get(0).getAccountBalance());
        assertEquals(wallet2.getAccountBalance(), result.get(1).getAccountBalance());
    }
    

    @Test
    @DisplayName("Test get wallet by id")
    public void testGetWalletById() {
        when(walletService.getWallet(1L)).thenReturn(wallet1);
    
        Wallet wallet = walletController.getWallet(1L);
    
        assertEquals(wallet1.getAccountBalance(), wallet.getAccountBalance());
        assertEquals(wallet1.getWalletPropietary(), wallet.getWalletPropietary());
        assertEquals(wallet1.getTransferHistorySends(), wallet.getTransferHistorySends());
        assertEquals(wallet1.getTransferHistoryReceivs(), wallet.getTransferHistoryReceivs());
        assertEquals(wallet1.getDepositHistory(), wallet.getDepositHistory());
    }
    
    @Test
    @DisplayName("Test get wallet by id not found")
    public void testGetWalletByIdNotFound() {
        when(walletService.getWallet(1L)).thenReturn(null);
    
        Wallet wallet = walletController.getWallet(1L);

        assertNull(wallet);
    }
    
    @Test
    @DisplayName("Test create wallet")
    public void testCreateWallet() throws UserNotFoundException {
        Wallet wallet = new Wallet();
        wallet.setId(3L);
        wallet.setAccountBalance(new BigDecimal("250.00"));
        wallet.setWalletPropietary(3L);
    
        walletController.createWallet(wallet);
    
        assertEquals(wallet.getAccountBalance(), wallet.getAccountBalance());
        assertEquals(wallet.getWalletPropietary(), wallet.getWalletPropietary());
        assertEquals(wallet.getTransferHistorySends(), wallet.getTransferHistorySends());
        assertEquals(wallet.getTransferHistoryReceivs(), wallet.getTransferHistoryReceivs());
        assertEquals(wallet.getDepositHistory(), wallet.getDepositHistory());
    }

}