package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repasitories.UserDAO;

import java.util.List;
@Service
public class UserServiceimpl implements UserService{


    private UserDAO userDAO;
    @Autowired
    public UserServiceimpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<User> findAll() {

        return userDAO.getAllUser() ;
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.getUserByName(username);
    }


    @Override
    public User findUserById(int id) {
        return userDAO.getUser(id);
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);

    }
    @Transactional
    @Override
    public boolean deleteUserById(int id) {
        userDAO.deleteUser(id);
        return false;
    }
}
