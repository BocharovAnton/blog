package com.example.blog.controllers;


import com.example.blog.models.Role;
import com.example.blog.models.User;
import com.example.blog.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class LogRegController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("title", "Логин");
        return "Login";
    }
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if(userFromDb != null ){
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);
        return "redirect:/login";
    }
}
