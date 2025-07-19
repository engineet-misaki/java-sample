package com.example.sample.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegistForm {

    @NotBlank
    private String greeting;

    private Integer intText;
}
