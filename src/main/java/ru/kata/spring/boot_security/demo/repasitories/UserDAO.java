package ru.kata.spring.boot_security.demo.repasitories;


import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUser();

    void saveUser(User user);

    User getUser(int id);

    User getUserByName(String userName);

    void deleteUser(int id);
}