package com.TestBirds.project_service.controller;

import com.TestBirds.project_service.dto.ProjectCreate;
import com.TestBirds.project_service.model.Project;
import com.TestBirds.project_service.model.User;
import com.TestBirds.project_service.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;

@RequestMapping("/projects")
@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    private Project fnf(String id){
        Project foundProject = projectService.getOne(id);
        if(foundProject == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return foundProject;
    }
    @PostMapping()
    public ResponseEntity<Project> crAction(@Valid @RequestBody ProjectCreate projectCreate) {
        Project newProject = projectService.pCreate(projectCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProject);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Project> goAction(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(fnf(id));
    }


}
