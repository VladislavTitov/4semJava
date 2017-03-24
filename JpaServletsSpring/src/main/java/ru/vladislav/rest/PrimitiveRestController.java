package ru.vladislav.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
public class PrimitiveRestController {
    @RequestMapping(value = "posts/{post-id}", method = RequestMethod.GET)
    @ResponseBody
    public String getPost(@PathVariable("post-id") int postId,
                          @RequestParam("action") String action) {
        if (action.equals("like")) {
            System.out.println(postId);
            Post post = new Post(true, "hello");
            ObjectMapper mapper = new ObjectMapper();
            String postAsJson = null;
            try {
                postAsJson = mapper.writeValueAsString(post);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            }
            return postAsJson;
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public void addPost(@RequestBody String postValue) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Post post = objectMapper.readValue(postValue, Post.class);
            System.out.println(post.getText());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
