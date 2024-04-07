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
    public User getUser(int id) {
        Query query = em.createQuery("Select u from User u left join fetch u.roles where u.id=:username");
        query.setParameter("username",id);
        return (User) query.getSingleResult();
    }

    @Override
    public void deleteUser(Long id) {

    }
}
