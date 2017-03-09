package ru.vladislav.servlets;

import org.springframework.context.ApplicationContext;
import ru.vladislav.entities.Post;
import ru.vladislav.entities.User;
import ru.vladislav.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class RegistrationServlet extends HttpServlet {

    UserService userService;
    Date currentDate;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ApplicationContext context = (ApplicationContext) config.getServletContext().getAttribute("springContext");
        userService = context.getBean(UserService.class);

        currentDate = new Date(System.currentTimeMillis());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String description = req.getParameter("description");
        User newUser = new User(userName, password, currentDate, description, new ArrayList<Post>());
        userService.save(newUser);
        resp.sendRedirect("/users");
    }
}
