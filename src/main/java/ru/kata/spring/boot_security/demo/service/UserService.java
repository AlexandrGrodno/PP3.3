package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);

    User findUserById(int id);

    void saveUser(User user);

    boolean deleteUserById(int id);
}
