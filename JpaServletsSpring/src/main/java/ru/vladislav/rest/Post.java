package ru.vladislav.rest;

public class Post {
    private boolean liked;
    private String text;

    public Post() {
    }

    public Post(boolean liked, String text) {
        this.liked = liked;
        this.text = text;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
