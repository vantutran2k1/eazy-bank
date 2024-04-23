package com.tutran.eazybank.controller;

import com.tutran.eazybank.model.AccountTransaction;
import com.tutran.eazybank.repository.AccountTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final AccountTransactionRepository accountTransactionRepository;

    @GetMapping("/myBalance")
    public List<AccountTransaction> getBalanceDetails(@RequestParam int id) {
        return accountTransactionRepository.findByCustomerIdOrderByTransactionDtDesc(id);
    }

}
