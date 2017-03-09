package ru.vladislav.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.vladislav.config.SpringConfig;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        servletContextEvent.getServletContext().setAttribute("springContext", context);
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
