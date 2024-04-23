package com.tutran.eazybank.repository;

import com.tutran.eazybank.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

    List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);

}