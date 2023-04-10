package com.agancy.real_estate.exception;

import com.fasterxml.jackson.core.JsonParseException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Locale;

@ControllerAdvice
@Slf4j
@AllArgsConstructor
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ValidationError> handleBindException(BindException ex) {
        log.error("A validation error occurred: ", ex);
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        return new ResponseEntity<>(processFieldErrors(fieldErrors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<ApiError> handleJsonParseException(JsonParseException ex) {
        log.error("Request JSON could no be parsed: ", ex);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiError body = new ApiError(
                "JSON_PARSE_ERROR",
                "The request could not be parsed as a valid JSON.",
                ex.getLocalizedMessage()
        );

        return new ResponseEntity<>(body, status);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("Illegal argument error: ", ex);
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ApiError body = new ApiError(
                "ILLEGAL_ARGUMENT_ERROR",
                "An illegal argument has been passed to the method.",
                ex.getLocalizedMessage()
        );

        return new ResponseEntity<>(body, status);
    }


    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiError> defaultErrorHandler(Throwable t) {
        log.error("An unexpected error occurred: ", t);
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiError body = new ApiError(
                "UNCLASSIFIED_ERROR",
                "Something unexpected occurred!",
                t.getLocalizedMessage()
        );

        return new ResponseEntity<>(body, status);
    }

    private ValidationError processFieldErrors(List<FieldError> fieldErrors) {
        ValidationError validationError = new ValidationError();
        for (FieldError fieldError : fieldErrors) {
            validationError.addValidationError(
                    fieldError.getField(),
                    messageSource.getMessage(fieldError, Locale.getDefault())
            );
        }

        return validationError;
    }
}
