package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.repasitories.UserRepository;

import java.util.List;

public class UserServiceimpl implements UserService{
    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private  UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByUsername(String username) {

        if (userRepository.findByUsername(username)==null) {
            throw new UsernameNotFoundException("Пользователь с таким именем не найден");
        }
        return userRepository.findByUsername(username);
        
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public void updateUser(User user, Long id) {

    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public boolean deleteUserById(Long id) {
        return false;
    }
}
