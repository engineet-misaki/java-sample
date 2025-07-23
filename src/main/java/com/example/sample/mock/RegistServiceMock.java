package com.example.sample.mock;

import com.example.sample.entity.Review;
import com.example.sample.service.RegistService;
import org.springframework.stereotype.Service;

//@Service
public class RegistServiceMock implements RegistService {
    @Override
    public String regist(Review dto) {
        return "mock";
    }
}
