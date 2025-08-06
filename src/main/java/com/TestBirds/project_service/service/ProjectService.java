package com.TestBirds.project_service.service;

import com.TestBirds.project_service.model.Project;

import org.springframework.stereotype.Service;

@Service
public class ProjectService  {
    public Project save(Project gen) {
        return gen;
    }

    public Project getOne(int id){
        Project newProject = new Project();
        newProject.setID(String.valueOf(id));
        return newProject;
    }
}
