package com.TestBirds.project_service.controller;

import com.TestBirds.project_service.model.User;
import com.TestBirds.project_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public User createAction(@Valid User user){
        return userService.save(user);
    }


}
