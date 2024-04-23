package com.tutran.eazybank.repository;

import com.tutran.eazybank.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findByCustomerId(int customerId);

}