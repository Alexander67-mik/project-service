package com.TestBirds.project_service.service;

import com.TestBirds.project_service.model.Project;

import org.springframework.stereotype.Service;

@Service
public class ProjectService implements IService<Project> {
    public Project save(Project gen) {
        return gen;
    }
}
