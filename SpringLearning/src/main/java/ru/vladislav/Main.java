package ru.vladislav;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vladislav.config.SpringConfig;
import ru.vladislav.dao.UserDao;
import ru.vladislav.entities.User;
import ru.vladislav.services.UserService;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user = userService.find(8L);

        int i = 0;
    }

}
