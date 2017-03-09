package ru.vladislav.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vladislav.dao.repository.UserRepo;
import ru.vladislav.entities.User;
import ru.vladislav.services.UserService;

@Service
@Transactional
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    public Long save(User user) {
        return userRepo.save(user).getId();
    }

    public User find(Long id) {
        return userRepo.findOne(id);
    }

    public User findByName(String name) {
        return null;
    }

    public void update(User user) {

    }

    public void delete(Long id) {

    }

    public boolean isGranted(String userName) {
        return false;
    }

    public boolean isRegistered(String userName) {
        return false;
    }
}
