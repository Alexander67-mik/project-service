package com.TestBirds.project_service.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Project {
           private String title;
    private  String id;
        private String description;
        private boolean active;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime createdAt = LocalDateTime.now();
       private User createdBy;
}
