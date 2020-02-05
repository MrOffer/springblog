package com.codeup.springblog.controllers;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class HomeController {
    private PostRepository postDao;

    public HomeController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/home/{user}")

    public String homePage(@PathVariable String user, Model model){
        model.addAttribute("user",user);
        model.addAttribute("posts", postDao.findAll());
        return "home";
    }
}