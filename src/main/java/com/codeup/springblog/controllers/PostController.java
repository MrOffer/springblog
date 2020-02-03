package com.codeup.springblog.controllers;



import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private EmailService emailService;
    private PostRepository postDao;
    private UserRepository userDao;


    public PostController(EmailService emailService, PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @RequestMapping(path = "/posts/edit/{id}")
    public String editPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    private String edit(@ModelAttribute Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}")
    public String viewPost(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getOne(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPostForm(Model model){
        model.addAttribute("post", new Post ());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitPost(@ModelAttribute Post post){

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        post.setUser(user);

        postDao.save(post);

        emailService.prepareAndSend(post, "You have created  post!", "Congrats!  Your post was created!");

        return "redirect:/posts";
    }

}