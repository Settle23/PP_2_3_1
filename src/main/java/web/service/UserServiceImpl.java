package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> usersList() {
        return userDao.usersList();
    }

    @Override
    public User getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    public void adduser(User user) {
        userDao.adduser(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }


}
