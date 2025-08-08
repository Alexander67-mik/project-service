package com.TestBirds.project_service.dto;

import com.TestBirds.project_service.model.User;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProjectUpdate {
    @NotBlank
    @Size(min = 5, max = 50)
    private String title;
    private  String iD;
    @Size(min = 5)
    private String description;
    @NotNull
    private boolean active;
    @NotNull
    private LocalDateTime createdAt;
}
