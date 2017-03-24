package ru.vladislav.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.vladislav.entities.Post;
import ru.vladislav.repository.PostsRepo;
import ru.vladislav.services.PostsService;

import java.util.ArrayList;
import java.util.List;

public class PostsServiceImpl implements PostsService {

    @Autowired
    private PostsRepo postsRepo;

    public Post save(Post post) {
        return postsRepo.save(post);
    }

    //TODO write this in repo
    public void updateContent(Post post) {

    }

    public void delete(Long id) {
        postsRepo.delete(id);
    }

    public void delete(Post post) {
        postsRepo.delete(post);
    }

    public List<Post> findAll() {
        List<Post> posts = new ArrayList<Post>();
        for (Post post :
                postsRepo.findAll()) {
            posts.add(post);
        }
        return posts;
    }

    public Post find(Long id) {
        return postsRepo.findOne(id);
    }

    public List<Post> findByUserId(Long id) {
        return postsRepo.findByUserId(id);
    }
}
