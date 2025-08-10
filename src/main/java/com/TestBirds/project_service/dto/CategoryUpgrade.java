package com.TestBirds.project_service.dto;

import com.TestBirds.project_service.model.Project;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryUpgrade {
    private int id;
    @NotBlank
    private String name;
    @NotNull
    private int priority;
    private List<Project> projects = new ArrayList<>();
}
