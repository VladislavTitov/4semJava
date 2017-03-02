package ru.vladislav.entities;

import javax.persistence.Entity;

@Entity
public class Child {
    
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private User user;
    
    
    public static class Builder{

        private Long id;
        private String surname;
        private String name;
        private String patronymic;
        private User user;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Child build(){
            return new Child(this);
        }

    }

    private Child(Builder builder) {
        this.id = builder.id;
        this.surname = builder.surname;
        this.name = builder.name;
        this.patronymic = builder.patronymic;
        this.user = builder.user;
    }

    public Child() {
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Child){
            if (this.id.equals(((Child) obj).getId()) && this.surname.equals(((Child) obj).getSurname())
                    && this.name.equals(((Child) obj).getName()) && this.patronymic.equals(((Child) obj).getPatronymic())
                    && this.user.getId().equals(((Child) obj).getUser().getId())){
                return true;
            }
        }
        return false;
    }
}
