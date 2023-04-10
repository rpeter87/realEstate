package com.agancy.real_estate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomFieldError {

    private String field;
    private String message;
}
