package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    Optional<User> findByUsername(String username);

    User findUserById(int id);

    void saveUser(User user);

    boolean deleteUserById(int id);
    User findByEmail(String email);
}
