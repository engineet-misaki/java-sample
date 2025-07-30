package com.example.sample.service;

import com.example.sample.entity.Review;
import com.example.sample.entity.Search;
import com.example.sample.repository.RegistRepository;
import com.example.sample.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final SearchRepository searchRepository;

    @Override
    public String search(Search dto) {
        List<Review> result = searchRepository.search(dto);
        String msg = "";
        for(Review one:result) {
            msg = msg + ", " + one.getGreeting();
        }
        return msg + "が登録されてます。";
    }
}
