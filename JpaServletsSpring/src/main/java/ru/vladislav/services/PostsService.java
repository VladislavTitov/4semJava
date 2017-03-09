package ru.vladislav.services;

import ru.vladislav.entities.Post;

import java.util.List;

public interface PostsService extends BaseService<Post> {

    void updateContent(Post post);

    List<Post> findByUserId(Long id);

}
