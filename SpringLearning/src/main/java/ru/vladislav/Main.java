package ru.vladislav;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vladislav.config.SpringConfig;
import ru.vladislav.dao.UserDao;
import ru.vladislav.entities.Child;
import ru.vladislav.entities.User;
import ru.vladislav.services.ChildrenService;
import ru.vladislav.services.UserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        /*UserService userService = context.getBean(UserService.class);

        User user = userService.find(8L);*/

        ChildrenService childrenService = context.getBean(ChildrenService.class);

        Child insertingChild = new Child.Builder()
                .setId(1L)
                .setSurname("AA")
                .setName("BB")
                .setPatronymic("CC")
                .setUser(new User.Builder().setId(1L).build())
                .build();

        Long id = childrenService.save(insertingChild);

        int i = 0;
    }

}
