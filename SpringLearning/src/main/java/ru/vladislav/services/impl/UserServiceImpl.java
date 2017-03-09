package ru.vladislav.services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import ru.vladislav.dao.ChildrenDao;
import ru.vladislav.dao.UserDao;
import ru.vladislav.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vladislav.services.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("dao.hibernate.children")
    private ChildrenDao childrenDao;

    public boolean isGranted(String userName) {
        List<User> users = userDao.findDeleted();

        for (User user :
                users) {
            if (user.getUserName().equals(userName)){
                return true;
            }

        }

        return false;
    }

    public boolean isRegistered(String userName) {
        List<User> users = userDao.findAll();

        for (User user :
                users) {
            if (user.getUserName().equals(userName)){
                return true;
            }

        }

        return false;
    }

    public Long save(User user) {
        return userDao.save(user);
    }

    public User find(Long id) {
        User user = userDao.find(id);
        user.getChildren().addAll(childrenDao.findByUserId(id));
        return user;
    }

    public User findByName(String name) {
        return userDao.findByName(name);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(Long id) {
        userDao.delete(id);
    }
}
