package ru.vladislav.controllers.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.vladislav.entities.User;
import ru.vladislav.services.UserService;

import java.sql.Date;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/anno-users", method = RequestMethod.GET)
    public ModelAndView getUsers(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersShow");
        modelAndView.addObject("users", userService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/anno-signup-post", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user){
        user.setDate_reg(new Date(System.currentTimeMillis()));
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", userService.findAll());
        modelAndView.setViewName("usersShow");
        return modelAndView;
    }

    @RequestMapping(value = "/anno-signup", method = RequestMethod.GET)
    public ModelAndView getSignup(Model model){
        model.addAttribute(new User());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayRegistration(Model model){
        model.addAttribute(new User());
        return "registration";
    }

}
