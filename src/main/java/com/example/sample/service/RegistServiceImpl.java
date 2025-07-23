package com.example.sample.service;

import com.example.sample.entity.Review;
import org.springframework.stereotype.Service;

@Service
public class RegistServiceImpl implements RegistService {

    @Override
    public String regist(Review dto) {
        String greeting = dto.getGreeting();
        return greeting + "登録完了";
    }
}
