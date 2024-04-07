package ru.kata.spring.boot_security.demo.repasitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import java.util.Optional;
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);

}
