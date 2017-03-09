package ru.vladislav;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vladislav.config.SpringConfig;
import ru.vladislav.dao.UserDao;
import ru.vladislav.entities.Child;
import ru.vladislav.entities.User;
import ru.vladislav.services.ChildrenService;
import ru.vladislav.services.UserService;

import java.sql.Date;
import java.util.List;

public class Main {

    @Autowired
    @Qualifier("services.jpa.user")
    UserService userService;

    public void showResults() {
        Long id = userService.save(
                new User.Builder()
                        .setId(2L)
                        .setUserName("jpaUserName")
                        .setPassword("234567432")
                        .setDateRegistration(new Date(2011, 11, 3))
                        .setDeleted(false)
                        .build()
        );
        int i = 0;
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);

        /*User user = userService.find(8L);*/

        /*ChildrenService childrenService = context.getBean(ChildrenService.class);

        Child insertingChild = new Child.Builder()
                .setId(1L)
                .setSurname("AA")
                .setName("BB")
                .setPatronymic("CC")
                .setUser(new User.Builder().setId(1L).build())
                .build();

        Long id = childrenService.save(insertingChild);*/

        User user = new User.Builder()
                .setId(2L)
                .setUserName("jpaUserName1")
                .setDateRegistration(new Date(41, 11, 3))
                .setDeleted(false)
                .setPassword("sf23t2wrhg24")
                .build();

        userService.save(user);

        User founded = userService.find(8L);

        int i = 0;
    }

}
