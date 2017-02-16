package ru.vladislav;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vladislav.config.SpringConfig;
import ru.vladislav.services.UserService;
import ru.vladislav.services.impl.UserServiceImpl;

public class Main {




    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.findByName("aeffew"));

    }

}
