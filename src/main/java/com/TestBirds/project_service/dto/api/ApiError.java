package com.TestBirds.project_service.dto.api;

public class ApiError {
    public String propertyPath;
    public String message;

    public ApiError(String propertyPath, String message) {
        this.propertyPath = propertyPath;
        this.message = message;
    }
}
