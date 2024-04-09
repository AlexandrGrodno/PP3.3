package ru.kata.spring.boot_security.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.service.UserDetailsServiceImpl;

import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {

    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    public AuthProviderImpl(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

//    @Autowired
//    public UserDetailsService AuthProviderImpl(UserDetailsService userService){
//        return this.userDetailsService = userService;
//    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();

        UserDetails userDetails = userDetailsService.loadUserByUsername(name);

        userDetails.getAuthorities().stream().forEach(System.out::println);
        String password = authentication.getCredentials().toString();

        if (!password.equals((userDetails.getPassword()))) {

            throw new BadCredentialsException("Password incorrect");
        }
        else
            return new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities() );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
