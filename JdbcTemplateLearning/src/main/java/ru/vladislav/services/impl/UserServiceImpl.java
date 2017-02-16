package ru.vladislav.services.impl;

import ru.vladislav.dao.UserDao;
import ru.vladislav.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vladislav.services.UserService;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public boolean isGranted(String userName) {
        return false;
    }

    public boolean isRegistered(String userName) {

        return false;
    }

    public Long save(User user) {
        return null;
    }

    public User find(Long id) {
        return null;
    }

    public User findByName(String name) {
        return userDao.findByName(name);
    }

    public void update(User user) {

    }

    public void delete(Long id) {

    }

    //TODO доделать сервисы
}
