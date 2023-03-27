package com.alexdev.bankapp.transfer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.alexdev.bankapp.transfer.application.TransferController;
import com.alexdev.bankapp.transfer.domain.Transfer;
import com.alexdev.bankapp.transfer.domain.TransferService;
import com.alexdev.bankapp.wallet.domain.Wallet;

@ExtendWith(MockitoExtension.class)
public class TransferControllerTest {

    @Mock
    private TransferService transferService;

    @InjectMocks
    private TransferController transferController;

    private List<Transfer> transfers;

    private List<Wallet> wallets;

    @BeforeEach
    public void setUp() {
        wallets = new ArrayList<>();
        wallets.add(new Wallet(1L, new BigDecimal("500.00"), 1L, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        wallets.add(new Wallet(2L, new BigDecimal("1000.00"), 2L, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));

        transfers = new ArrayList<>();
        transfers.add(new Transfer(1L, wallets.get(0), wallets.get(1), new BigDecimal("100.00"), LocalDateTime.now()));
        transfers.add(new Transfer(2L, wallets.get(0), wallets.get(1), new BigDecimal("200.00"), LocalDateTime.now()));
        transfers.add(new Transfer(3L, wallets.get(1), wallets.get(0), new BigDecimal("50.00"), LocalDateTime.now()));

        wallets.get(0).getTransferHistorySends().add(transfers.get(0));
        wallets.get(0).getTransferHistorySends().add(transfers.get(1));
        wallets.get(0).getTransferHistoryReceivs().add(transfers.get(2));
        wallets.get(1).getTransferHistoryReceivs().add(transfers.get(0));
        wallets.get(1).getTransferHistoryReceivs().add(transfers.get(1));
        wallets.get(1).getTransferHistorySends().add(transfers.get(2));
    }

    @Test
    public void getAllTransfersTest() {
        when(transferService.getTransfers()).thenReturn(transfers);
        List<Transfer> response = transferController.getAllTranfers();
        assertEquals(transfers, response);
    }

    @Test
    public void getTransferTest() {
        Transfer transfer = transfers.get(0);
        when(transferService.getTransfer(1L)).thenReturn(transfer);
        Transfer response = transferController.getTransfer(1L);
        assertEquals(transfer, response);
    }

    @Test
    public void createTransferTest() {
        Wallet originWallet = wallets.get(0);
        Wallet destinyWallet = wallets.get(1);
        Transfer transfer = new Transfer(4L, originWallet, destinyWallet, new BigDecimal("150.00"), LocalDateTime.now());

        assertEquals(4L, transfer.getId());
        assertEquals(originWallet, transfer.getOriginWallet());
        assertEquals(destinyWallet, transfer.getDestinyWallet());
        assertEquals(new BigDecimal("150.00"), transfer.getAmount());
    }
}