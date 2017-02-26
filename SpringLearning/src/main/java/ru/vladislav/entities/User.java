package ru.vladislav.entities;

import java.sql.Date;
import java.util.List;

public class User {

    private Long id;
    private String userName;
    private String password;
    private Date dateRegistration;
    private boolean deleted;
    private List<Child> children;

    public static class Builder{

        private Long id;
        private String userName;
        private String password;
        private Date dateRegistration;
        private boolean deleted;
        private List<Child> children;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setDateRegistration(Date dateRegistration) {
            this.dateRegistration = dateRegistration;
            return this;
        }

        public Builder setDeleted(boolean deleted) {
            this.deleted = deleted;
            return this;
        }

        public Builder setChildren(List<Child> children) {
            this.children = children;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.password = builder.password;
        this.dateRegistration = builder.dateRegistration;
        this.deleted = builder.deleted;
        this.children = builder.children;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
