package com.agancy.real_estate.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {

    private String errorCode;
    private String error;
    private String details;
}
