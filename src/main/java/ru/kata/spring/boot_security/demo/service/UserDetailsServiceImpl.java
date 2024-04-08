package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import ru.kata.spring.boot_security.demo.repasitories.UserDAOImpl;
import ru.kata.spring.boot_security.demo.repasitories.UserRepository;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;


    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ru.kata.spring.boot_security.demo.models.User userOp = userRepository.findByUsername(username);
        System.out.println(userOp+"  !   "+ username);
        if (userOp == null) throw  new UsernameNotFoundException("User not found!");
        UserDetails userDetails = User.builder()
                .username(userOp.getUsername())
                .password(userOp.getPassword())
                .authorities(userOp.getAuthorities())
                .build();
        return userDetails;
    }
}
