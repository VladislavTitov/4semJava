package ru.vladislav.services;

import ru.vladislav.entities.User;


public interface UserService extends BaseService<User>{

    void updateUserDescription(User user);

    User find(String name);

}
