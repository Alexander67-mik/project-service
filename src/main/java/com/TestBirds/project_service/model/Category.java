package com.TestBirds.project_service.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Category {
    private int id;
    private String name;
    private int priority;
    private List<Project> projects = new ArrayList<>();
}
