package ru.vladislav.entities;

import java.sql.Date;

public class User {

    private final Long id;
    private final String userName;
    private final String password;
    private final Date dateRegistration;
    private final boolean deleted;

    public static class Builder{

        private Long id;
        private String userName;
        private String password;
        private Date dateRegistration;
        private boolean deleted;

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateRegistration=" + dateRegistration +
                ", deleted=" + deleted +
                '}';
    }
}
