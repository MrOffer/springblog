package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{num}/and/{num1}", method = RequestMethod.GET)
    @ResponseBody
    public String add(@PathVariable int num, @PathVariable int num1) {
        return num + " + " + num1 + " = " + (num + num1);
    }

    @RequestMapping(path = "/subtract/{num}/from/{num1}", method = RequestMethod.GET)
    @ResponseBody
    public String subtract(@PathVariable int num, @PathVariable int num1) {
        return num + " - " + num1 + " = " + (num - num1);
    }

    @RequestMapping(path = "/multiply/{num}/anb/{num1}", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@PathVariable int num, @PathVariable int num1) {
        return num + " X " + num1 + " = " + (num * num1);
    }

    @RequestMapping(path = "/divide/{num}/by/{num1}", method = RequestMethod.GET)
    @ResponseBody
    public String divide(@PathVariable int num, @PathVariable int num1) {
        return num + " / " + num1 + " = " + (num / num1);
    }

}
