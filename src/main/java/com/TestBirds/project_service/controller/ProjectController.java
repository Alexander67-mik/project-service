package com.TestBirds.project_service.controller;

import com.TestBirds.project_service.dto.ProjectCreate;
import com.TestBirds.project_service.dto.ProjectUpdate;
import com.TestBirds.project_service.model.Project;
import com.TestBirds.project_service.model.User;
import com.TestBirds.project_service.service.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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
    @PatchMapping("/{id}")
    public ResponseEntity<Project> upOneAction(@PathVariable String id, @RequestBody ProjectUpdate pData){
        Project foundProject = fnf(id);
        Project updatedProject = projectService.upOne(pData, foundProject);
        return ResponseEntity.ok(updatedProject);
    }
    @GetMapping()
    public ResponseEntity<List<Project>> findAllPr(@RequestParam(required = false) String title){
        List<Project> projects = projectService.findAllProjects(title);
        return ResponseEntity.ok(projects);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Project> dellOneAction(@PathVariable String id){
        Project foundProject = fnf(id);
        projectService.delOne(foundProject);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
