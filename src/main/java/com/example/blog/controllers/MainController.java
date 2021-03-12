package com.example.blog.controllers;

import com.example.blog.models.Post;
import com.example.blog.repos.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class MainController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/main")
    public String home(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "Home";
    }
}
