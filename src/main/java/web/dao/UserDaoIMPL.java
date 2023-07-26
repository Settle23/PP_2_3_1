package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoIMPL implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<User> usersList() {
        return entityManager.createQuery("SELECT u From User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void adduser(User user) {
        entityManager.persist(user);
    }

    @Transactional
    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Transactional
    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}
