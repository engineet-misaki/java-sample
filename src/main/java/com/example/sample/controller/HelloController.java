package com.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model, @RequestParam(required = false, defaultValue = "testのパラメータなし") String test) {
        model.addAttribute("welcome","文字追加");
        model.addAttribute("test",test);

        return "hello";
    }
}
