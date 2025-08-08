package com.TestBirds.project_service.exception;

import com.TestBirds.project_service.dto.api.ApiError;
import com.TestBirds.project_service.dto.api.ApiErrors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class GlobalValidationErrorsHandler {

    @ExceptionHandler(WebExchangeBindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<ApiErrors> handleValidationException(WebExchangeBindException ex) {
        ApiErrors errors = new ApiErrors();
        errors.title = "Validation Error";
        if (ex.getBindingResult() != null) {
            ex.getBindingResult().getFieldErrors().forEach(error ->
                    errors.violations.add(new ApiError(error.getField(), error.getDefaultMessage())));
        } else {
            errors.violations.add(new ApiError("unknownField", ex.getReason() != null
                    ? ex.getReason() : "Invalid request data"));
        }
        return Mono.just(errors);
    }
}
