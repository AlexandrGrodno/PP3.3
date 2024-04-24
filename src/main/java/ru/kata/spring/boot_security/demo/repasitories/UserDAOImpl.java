package ru.kata.spring.boot_security.demo.repasitories;

import static ru.kata.spring.boot_security.demo.configs.WebSecurityConfig.passwordEncoder;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUser() {
        Query query = em.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void saveUser(User user) {
        if (user.getPassword().indexOf("$2a$10$") != 0 ) user.setPassword(passwordEncoder().encode(user.getPassword()));
        em.merge(user);
    }

    @Override
    public User getUser(int id) {
        Query query = em.createQuery("Select u from User u left join fetch u.roles where u.id=:idUser");
        query.setParameter("idUser", id);
        return (User) query.getSingleResult();
    }

    @Override
    public String getEmail(String userName) {

        return null;
    }

    @Override
    public User getUserByName(String userName) {
        Query query = em.createQuery("Select u from User u left join fetch u.roles where u.userName=:userName");
        query.setParameter("userName", userName);
        return (User) query.getSingleResult();
    }

    @Override
    public void deleteUser(int id) {
        em.remove(getUser(id));
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = em.createQuery("Select u from User u left join fetch u.roles where u.email=:email");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }
}
