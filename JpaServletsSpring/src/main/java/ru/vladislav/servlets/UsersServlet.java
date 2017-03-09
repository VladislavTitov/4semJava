package ru.vladislav.servlets;

import org.springframework.context.ApplicationContext;
import ru.vladislav.entities.User;
import ru.vladislav.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UsersServlet extends HttpServlet {

    UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("springContext");
        userService = context.getBean(UserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        List<User> users = userService.findAll();
        for (User user :
                users) {
            writer.print(user.getName() + "\n\t" + user.getDescription() +"\n\n");
        }
    }
}
