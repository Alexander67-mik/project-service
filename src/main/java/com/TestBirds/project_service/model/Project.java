package com.TestBirds.project_service.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Project {
    @NotBlank
    @Size(min = 5, max = 50)
    private String title;
    private  String iD;
    @Size(min = 20)
    private String description;
    @NotNull
    private boolean active;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private User createdBy;

    public String getTitle() {
        return title;

    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getID() {
        return iD;
    }
    public void setID(String iD) {
        this.iD = iD;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }




}
