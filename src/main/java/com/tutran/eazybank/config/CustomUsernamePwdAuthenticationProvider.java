package com.tutran.eazybank.config;

import com.tutran.eazybank.model.Authority;
import com.tutran.eazybank.model.Customer;
import com.tutran.eazybank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CustomUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();

        List<Customer> customers = customerRepository.findByEmail(username);
        if (customers.isEmpty()) {
            throw new BadCredentialsException("User not found");
        }

        String password = authentication.getCredentials().toString();
        Customer customer = customers.getFirst();
        if (passwordEncoder.matches(password, customer.getPwd())) {
            return new UsernamePasswordAuthenticationToken(
                    customer.getEmail(),
                    password,
                    getAuthorities(customer.getAuthorities())
            );
        } else {
            throw new BadCredentialsException("Wrong password");
        }
    }

    private List<GrantedAuthority> getAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
