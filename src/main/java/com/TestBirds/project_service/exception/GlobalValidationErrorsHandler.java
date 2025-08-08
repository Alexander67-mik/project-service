package com.TestBirds.project_service.exception;

import com.TestBirds.project_service.dto.api.ApiError;
import com.TestBirds.project_service.dto.api.ApiErrors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalValidationErrorsHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationException(MethodArgumentNotValidException ex) {
        ApiErrors errors = new ApiErrors();
        errors.title = "Validation Error";
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.violations.add(new ApiError(error.getField(), error.getDefaultMessage())));
        return errors;
    }
}
