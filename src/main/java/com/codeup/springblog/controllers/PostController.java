package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repositories.postRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {

    private postRepository postDao;

    public PostController(postRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String Post(@PathVariable Long id, Model model) {
        model.addAttribute("posts", postDao.getOne(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public void createPost() {
        Post post = new Post();
        post.setTitle("Title 3");
        post.setBody("this is the body of the 3rd post");
        postDao.save(post);
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String created() {
        return "create a new post";
    }

    @RequestMapping(path = "posts/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @RequestMapping(path = "/posts/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/post/edit/")
    private String updatePost(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }



}
