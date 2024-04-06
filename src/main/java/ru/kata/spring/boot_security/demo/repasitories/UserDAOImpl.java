package ru.kata.spring.boot_security.demo.repasitories;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public void saveUser(User user) {
        em.merge(user);

    }

    @Override
    public User getUser(String name) {
        Query query = em.createQuery("FROM User where username =:name");
        query.setParameter("name",name);
        return (User) query.getSingleResult();
    }

    @Override
    public void deleteUser(Long id) {

    }
}
