package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class daysLeft {
    @GetMapping("/deimos")
    @ResponseBody
    public String daysLeft(){
        return "31 days left";
    }

    @GetMapping("/deimos/{days}")
    @ResponseBody
    public String hello(@PathVariable String days) {
        return "There are " + days + " left";
    }

    @GetMapping("/")
    @ResponseBody
    public String landing() {
        return "This is the landing page!";
    }
}
