package com.agancy.real_estate.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ValidationError {

    private List<CustomFieldError> fieldErrors = new ArrayList<>();

    public void addValidationError(String field, String message) {
        CustomFieldError error = new CustomFieldError(field,message);
        fieldErrors.add(error);
    }
}
