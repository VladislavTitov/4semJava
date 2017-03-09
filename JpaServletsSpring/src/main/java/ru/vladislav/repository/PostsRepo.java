package ru.vladislav.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.vladislav.entities.Post;

import java.util.List;

public interface PostsRepo extends CrudRepository<Post, Long> {

    @Query("select post from Post post where post.user.id = :userId")
    List<Post> findByUserId(@Param("userId") Long userId);

}
