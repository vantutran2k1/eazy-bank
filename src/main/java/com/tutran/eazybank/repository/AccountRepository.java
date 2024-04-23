package com.tutran.eazybank.repository;

import com.tutran.eazybank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByCustomerId(int customerId);

}