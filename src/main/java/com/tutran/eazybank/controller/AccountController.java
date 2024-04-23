package com.tutran.eazybank.controller;

import com.tutran.eazybank.model.Account;
import com.tutran.eazybank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestParam int id) {
        return accountRepository.findByCustomerId(id);
    }

}
