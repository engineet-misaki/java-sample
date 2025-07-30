package com.example.sample.repository;

import com.example.sample.entity.Review;
import com.example.sample.entity.Search;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchRepositoryImpl implements SearchRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Review> search(Search search) {
        String sql =
                "SELECT * FROM greeting";
        List<Review> list = jdbcTemplate.query(sql, new DataClassRowMapper<>(Review.class));
        return list;
    }
}
