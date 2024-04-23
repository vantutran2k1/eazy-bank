package com.tutran.eazybank.repository;

import com.tutran.eazybank.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, String> {

    List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}