package com.tutran.eazybank.controller;

import com.tutran.eazybank.model.Loan;
import com.tutran.eazybank.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loan> getLoansDetails(@RequestParam int id) {
        return loanRepository.findByCustomerIdOrderByStartDtDesc(id);
    }

}
