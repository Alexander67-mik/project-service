package com.TestBirds.project_service.model;

import com.TestBirds.project_service.enums.UserRow;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class User {
    private Integer id;
  private String username;
  @JsonIgnore
   private List<UserRow> roles = new ArrayList<>();
   private String language;
}
