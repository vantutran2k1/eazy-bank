package com.tutran.eazybank.controller;

import com.tutran.eazybank.model.Card;
import com.tutran.eazybank.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardRepository cardRepository;

    @GetMapping("/myCards")
    public List<Card> getCardDetails(@RequestParam int id) {
        return cardRepository.findByCustomerId(id);
    }

}
