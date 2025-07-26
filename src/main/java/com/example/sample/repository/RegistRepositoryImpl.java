package com.example.sample.repository;

import com.example.sample.entity.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RegistRepositoryImpl implements RegistRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void add(Review review) {
        String sql =
                "INSERT INTO greeting" +
                "(greeting, greeting_num)" +
                "VALUES(?, ?)";
        jdbcTemplate.update(sql, review.getGreeting(),review.getIntText());
    }
}
