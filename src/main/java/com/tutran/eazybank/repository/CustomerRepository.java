package com.tutran.eazybank.repository;

import com.tutran.eazybank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByEmail(String email);

}