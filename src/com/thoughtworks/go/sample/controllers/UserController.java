package com.thoughtworks.go.sample.controllers;

import com.thoughtworks.go.sample.models.User;
import com.thoughtworks.go.sample.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/users/new", method = RequestMethod.GET)
    public ModelAndView newUser(HttpServletRequest request, HttpServletResponse response) {
        Map model = new HashMap();
        HttpSession session = request.getSession(false);
        if (session != null) {
            model.put("message", session.getAttribute("flash"));
            session.removeAttribute("flash");
        }
        return new ModelAndView("user/new", model);
    }

    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public ModelAndView createUser(@RequestParam("name") String name,
                                   @RequestParam("age") String age,
                                   HttpServletRequest request, HttpServletResponse response) {
        userRepository.save(new User(name, Integer.parseInt(age)));
        request.getSession(true).setAttribute("flash", "User created successfully");
        return new ModelAndView(new RedirectView("/users/new", true));
    }
}
