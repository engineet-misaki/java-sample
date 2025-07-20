package com.example.sample.controller;

import com.example.sample.form.RegistForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {


    @GetMapping("/hello-old")
    public String hello(Model model, @RequestParam(required = false, defaultValue = "testのパラメータなし") String test) {
        model.addAttribute("welcome","文字追加");
        model.addAttribute("test",test);

        return "hello";
    }

    @GetMapping("/hello")
    public String hello(@ModelAttribute RegistForm form) {

        return "hello";
    }

    @PostMapping("/post")
    public String post(@Validated @ModelAttribute RegistForm form, BindingResult result) {
        if(result.hasErrors()) {

            return "res";
        }
        return  "res";
    }
}
