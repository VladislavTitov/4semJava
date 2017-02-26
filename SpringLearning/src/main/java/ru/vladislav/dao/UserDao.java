package ru.vladislav.dao;

import ru.vladislav.entities.User;

import java.sql.Date;
import java.util.List;

public interface UserDao extends BaseDao<User> {

    List<User> findByDateRegistration(Date date);

    List<User> findDeleted();

    User findByName(String name);

}
