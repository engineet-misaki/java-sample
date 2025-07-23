package com.example.sample.controller;

import com.example.sample.entity.Review;
import com.example.sample.form.RegistForm;
import com.example.sample.service.RegistService;
import com.example.sample.service.RegistServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final RegistService service;

//    @Autowired
//    public HelloController(RegistService service) {
//        this.service = service
//    }

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
            return "hello";
        }
        return  "res";
    }

    @PostMapping("/complete")
    public String complete(@Validated RegistForm form, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "hello";
        }

        // DIしてるのでいらない
        // RegistService service = new RegistServiceImpl();
        Review dto = new Review();
        dto.setGreeting(form.getGreeting());
        dto.setIntText(form.getIntText());
        String msg = service.regist(dto);

        model.addAttribute("msg",msg);

        return  "complete";
    }
}
