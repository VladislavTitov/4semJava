package ru.vladislav.entities;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;

    @Column(name = "post_content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Post){
            if (this.getPost_id().equals(((Post) obj).getPost_id()) && this.getContent().equals(((Post) obj).getContent())
                    && this.getUser().getUser_id().equals(((Post) obj).getUser().getUser_id())){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "postId: " + this.post_id + ";\n" +
                "content: " + this.content + ";\n" +
                "userId: " + this.user.getUser_id() + ";";
    }
}
