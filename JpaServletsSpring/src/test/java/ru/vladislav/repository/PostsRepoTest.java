package ru.vladislav.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.vladislav.entities.Post;
import ru.vladislav.entities.User;
import ru.vladislav.repository.config.persistence.PersistenceTestConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceTestConfig.class)
public class PostsRepoTest {

    @Autowired
    PostsRepo postsRepo;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void findByUserId() throws Exception {
        List<Post> actual = postsRepo.findByUserId(3L);
        List<Post> expected = new ArrayList<Post>();
        Post expectedPost = new Post();
        expectedPost.setPost_id(8L);
        expectedPost.setContent("3. Lorem ipsum dolor sit amet, " +
                "consectetur adipiscing elit, " +
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi " +
                "ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit " +
                "in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, " +
                "sunt in culpa qui officia deserunt mollit anim id est laborum.");
        User expectedUser = new User();
        expectedUser.setUser_id(3L);
        expectedPost.setUser(expectedUser);
        expected.add(expectedPost);

        System.out.println(actual.get(0));

        assertEquals(expected, actual);
    }

}