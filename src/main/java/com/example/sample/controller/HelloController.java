package com.example.sample.controller;

import com.example.sample.entity.Review;
import com.example.sample.entity.Search;
import com.example.sample.form.RegistForm;
import com.example.sample.form.SearchForm;
import com.example.sample.service.RegistService;
import com.example.sample.service.RegistServiceImpl;
import com.example.sample.service.SearchService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final RegistService service;
    private final SearchService searchService;

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
    public String hello(@ModelAttribute RegistForm form, @ModelAttribute SearchForm search) {

        Search dto = new Search();
        dto.setSearch(search.getSearch());
        String result = searchService.search(dto);
        search.setSearchResult(result);

        return "hello";
    }

    @GetMapping("/complete")
    public String complete() {
        return "complete";
    }

    @PostMapping("/post")
    public String post(@Validated @ModelAttribute RegistForm form, BindingResult result) {
        if(result.hasErrors()) {
            return "hello";
        }
        return  "res";
    }

    @PostMapping("/complete")
    public String complete(@Validated RegistForm form, BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()) {
            return "hello";
        }

        // DIしてるのでいらない
        // RegistService service = new RegistServiceImpl();
        Review dto = new Review();
        dto.setGreeting(form.getGreeting());
        dto.setIntText(form.getIntText());
        String msg = service.regist(dto);

        redirectAttributes.addFlashAttribute("msg",msg);

        return  "redirect:/complete";
    }
}
