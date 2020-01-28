package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        ArrayList<Post> postList = new ArrayList<Post>();
        postList.add(new Post((long) 2, "Title 2", "Description 2"));
        postList.add(new Post((long) 3, "Title 3", "Description 3"));

        model.addAttribute("posts", postList);

        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String id(@PathVariable Long id , Model model) {

        Post post1 = new Post((long) 1, "Title 1", "Body 1");
        model.addAttribute("title", post1.getTitle());
        model.addAttribute("body", post1.getBody());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String create() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String created() {
        return "create a new post";
    }

}
