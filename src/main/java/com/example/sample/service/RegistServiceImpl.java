package com.example.sample.service;

import com.example.sample.entity.Review;
import com.example.sample.repository.RegistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistServiceImpl implements RegistService {

    private final RegistRepository registRepository;

    @Override
    public String regist(Review dto) {
        String greeting = dto.getGreeting();
        registRepository.add(dto);
        return greeting + "を登録完了しました";
    }
}
