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
        System.out.println("!!!!!!");
        String name = authentication.getName();
        System.out.println("&&&&&");
        UserDetails userDetails = userDetailsService.loadUserByUsername(name);
        System.out.println(name);
        System.out.println(userDetails.getUsername());
        String password = authentication.getCredentials().toString();
        if (!password.equals((userDetails.getPassword()))) {
            System.out.println(userDetailsService.loadUserByUsername(name)+"     "+name);
            throw new BadCredentialsException("Password incorrect");
        }
        else
            return new UsernamePasswordAuthenticationToken(userDetails,password, Collections.emptyList());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
