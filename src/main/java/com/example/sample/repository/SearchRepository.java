package com.example.sample.repository;

import com.example.sample.entity.Review;
import com.example.sample.entity.Search;

import java.util.List;

public interface SearchRepository {
    List<Review> search(Search search);
}
