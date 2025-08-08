package com.TestBirds.project_service.service;

import com.TestBirds.project_service.dto.ProjectCreate;
import com.TestBirds.project_service.dto.ProjectUpdate;
import com.TestBirds.project_service.enums.UserRow;
import com.TestBirds.project_service.mapper.ProjectMapper;
import com.TestBirds.project_service.model.Project;
import com.TestBirds.project_service.model.User;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectService  {
    private final ProjectMapper projectMapper = ProjectMapper.INSTANCE;

    public Project save(Project gen) {
        return gen;
    }

    public Project getOne(String id) {
        System.out.println(id);
        if (!id.equals("project1")) {
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
    public Project upOne(ProjectUpdate pData, Project project){
        projectMapper.proUpdate(pData, project);
        save(project);
        return project;
    }
    public void delOne(Project del1){

    }
    public List<Project> findAllProjects(String title) {
        Project project1 = new Project();
        Project project2 = new Project();
        Project project3 = new Project();
        project1.setId("project1");
        project1.setTitle("Zaglavie");
        project1.setDescription("opisanieto trqbva da bude mnogo dulgo inache ne go validira");
        project1.setActive(true);
        project1.setCreatedAt(LocalDateTime.now());
        project2.setId("project2");
        project2.setTitle("Zaglavie2");
        project2.setDescription("opisanie za wtoroto");
        project2.setActive(true);
        project2.setCreatedAt(LocalDateTime.now());
        project3.setId("project3");
        project3.setTitle("Zaglavie3");
        project3.setDescription("opisanie za tretoto");
        project3.setActive(true);
        project3.setCreatedAt(LocalDateTime.now());
        return List.of(project1, project2, project3).stream().filter(p -> p.getTitle().equals(title)).toList();
    }

    public Project pCreate(ProjectCreate pr){
        Project project = projectMapper.proCreate(pr);
        User user = new User();
        user.setId(1);
        user.setUsername("Alexander");
        user.setLanguage("bg");
        user.setRoles(List.of(UserRow.ADMIN, UserRow.USER));
        project.setCreatedBy(user);
        save(project);
        return project;
    }
}
