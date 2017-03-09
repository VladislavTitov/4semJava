package ru.vladislav.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vladislav.entities.User;

public interface UserRepo extends CrudRepository<User, Long> {

    @Query(value = "select user from User user where user.name = :userName")
    User findByUserName(@Param("userName") String userName);

    @Modifying(clearAutomatically = true)
    @Query(value = "update User user set user.description = :descr where user.id = :userId")
    void updateUserDescription(@Param("userId") Long userId, @Param("descr") String description);

}
