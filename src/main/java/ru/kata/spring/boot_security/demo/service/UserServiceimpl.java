package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repasitories.UserDAO;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {


    private UserDAO userDAO;

    @Autowired
    public UserServiceimpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {
        return userDAO.getAllUser();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(userDAO.getUserByName(username));
    }
    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userDAO.getUserByEmail(email));
    }

    @Override
    public User findUserById(int id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }

    @Override
    @Transactional
    public boolean deleteUserById(int id) {
        userDAO.deleteUser(id);
        return false;
    }
}
