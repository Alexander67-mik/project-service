package com.TestBirds.project_service.service;

import com.TestBirds.project_service.dto.ProjectCreate;
import com.TestBirds.project_service.dto.ProjectUpdate;
import com.TestBirds.project_service.mapper.ProjectMapper;
import com.TestBirds.project_service.model.Project;
import com.TestBirds.project_service.model.User;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProjectService  {
    private final ProjectMapper projectMapper = ProjectMapper.INSTANCE;
    public Project save(Project gen) {
        return gen;
    }

    public Project getOne(String id) {
        if (id != "project1" ) {
            return null;
        }
        Project newProject = new Project();
        newProject.setId(id);
        newProject.setTitle("Zaglavie");
        newProject.setDescription("opisanieto trqbva da bude mnogo dulgo inache ne go validira");
        newProject.setActive(true);
        newProject.setCreatedAt(LocalDateTime.now());
        newProject.setCreatedBy(new User());
        return newProject;
    }




    public Project myTitle(String title){
        Project newProject = new Project();
        newProject.setTitle(title);
        return newProject;
    }
    public Project pCreate(ProjectCreate pr){
        Project project = projectMapper.proCreate(pr);
        save(project);
        return project;
    }
}
