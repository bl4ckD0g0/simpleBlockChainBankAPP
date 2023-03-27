package com.alexdev.bankapp.deposit;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.alexdev.bankapp.deposit.application.DepositController;
import com.alexdev.bankapp.deposit.domain.Deposit;
import com.alexdev.bankapp.deposit.domain.DepositService;
import com.alexdev.bankapp.wallet.domain.Wallet;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(DepositController.class)
public class DepositControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepositService depositService;

    @InjectMocks
    private DepositController depositController;

    
    @Test
    public void testGetAllDeposits() throws Exception {
        List<Deposit> deposits = new ArrayList<>();
        deposits.add(new Deposit(1L, new Wallet(), new BigDecimal("100.00"), LocalDateTime.now()));
        deposits.add(new Deposit(2L, new Wallet(), new BigDecimal("200.00"), LocalDateTime.now()));

        Mockito.when(depositService.getDeposits()).thenReturn(deposits);

        mockMvc.perform(MockMvcRequestBuilders.get("/deposits"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].amount", Matchers.is(100.00)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].amount", Matchers.is(200.00)));
    }

    @Test
    public void testGetDeposit() throws Exception {
        Deposit deposit = new Deposit(1L, new Wallet(), new BigDecimal("100.00"), LocalDateTime.now());

        Mockito.when(depositService.getDeposit(1L)).thenReturn(deposit);

        mockMvc.perform(MockMvcRequestBuilders.get("/deposits/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount", Matchers.is(100.00)));
    }

    @Test
    public void testCreateDeposit() {
               
        Deposit deposit = new Deposit();
        deposit.setAmount(new BigDecimal(100));
        deposit.setDate(LocalDateTime.now());

        depositController.createDeposit(deposit);

        verify(depositService, times(1)).createDeposit(deposit);
    }
}