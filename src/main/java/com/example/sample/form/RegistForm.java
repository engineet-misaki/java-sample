package com.example.sample.form;

import lombok.Data;
import lombok.NonNull;

@Data
public class RegistForm {

    @NonNull
    private String greeting;

    private Integer intText;
}
