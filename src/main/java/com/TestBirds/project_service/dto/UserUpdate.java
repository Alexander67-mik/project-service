package com.TestBirds.project_service.dto;

import com.TestBirds.project_service.enums.UserRow;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserUpdate {
    private Integer id;
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @Size(min = 1)
    private List<UserRow> roles = new ArrayList<>();
    @NotBlank
    private String language;
}
