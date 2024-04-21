package com.tutran.eazybank.config;

import com.tutran.eazybank.model.Customer;
import com.tutran.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = customerRepository.findByEmail(username);

        if (customers.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        } else {
            var customer = customers.getFirst();
            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));

            return new User(username, customer.getPwd(), authorities);
        }
    }

}
