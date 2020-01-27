package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class daysLeft {
    @GetMapping("/deimos")
    public String days(){
        return "days";
    }

    @GetMapping("/deimos/{days}")
    public String hello(@PathVariable String days, Model model) {
        model.addAttribute("days", days);
        return "days";
    }

    @GetMapping("/")
    @ResponseBody
    public String landing() {
        return "This is the landing page!";
    }
}
