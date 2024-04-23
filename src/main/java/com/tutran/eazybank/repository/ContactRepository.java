package com.tutran.eazybank.repository;

import com.tutran.eazybank.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, String> {
}