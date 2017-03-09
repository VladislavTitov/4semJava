package ru.vladislav.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vladislav.entities.User;
import ru.vladislav.repository.UserRepo;
import ru.vladislav.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;


    public User save(User user) {
        return userRepo.save(user);
    }

    public void updateUserDescription(User user) {
        userRepo.updateUserDescription(user.getUser_id(), user.getDescription());
    }

    public void delete(Long id) {
        userRepo.delete(id);
    }

    public void delete(User user) {
        userRepo.delete(user);
    }

    public List<User> findAll() {
        List<User> users = new ArrayList<User>();
        for (User user :
                userRepo.findAll()) {
            users.add(user);
        }
        return users;
    }

    public User find(Long id) {
        return userRepo.findOne(id);
    }

    public User find(String userName) {
        return userRepo.findByUserName(userName);
    }
}
