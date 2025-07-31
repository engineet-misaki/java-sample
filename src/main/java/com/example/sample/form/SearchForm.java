package com.example.sample.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SearchForm {

    private String search;

    private String searchResult;
}
