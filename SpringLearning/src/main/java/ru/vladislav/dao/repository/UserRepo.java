package ru.vladislav.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vladislav.entities.User;

import java.sql.Date;
import java.util.List;

public interface UserRepo extends CrudRepository<User, Long> {

    @Query(value = "select user from User user where user.dateRegistration = :date")
    List<User> findByDateRegistration(@Param("date") Date date);

    @Query(value = "select user from User user where user.deleted = true")
    List<User> findDeleted();

    @Query(value = "select user from User user where user.userName = :name")
    User findByName(@Param("name") String name);

}
