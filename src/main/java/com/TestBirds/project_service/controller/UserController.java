package com.TestBirds.project_service.controller;

import com.TestBirds.project_service.model.User;
import com.TestBirds.project_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/users")
    public ResponseEntity<User> createAction(@Valid @RequestBody User user) {
        User newUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getOneAction(@PathVariable Integer id) {
        User existingUser = userService.getOne(id);
        if(existingUser == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(existingUser);
    }
    @PatchMapping("/users/{id}")
    public ResponseEntity<User> updateOneAction(@PathVariable Integer id, @RequestBody User data){
        User foundUser = userService.getOne(id);
        if(foundUser == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        foundUser.setUsername(data.getUsername());
        foundUser.setLanguage(data.getLanguage());
        foundUser.setRoles(data.getRoles());
        User updatedUser = userService.updateOne(foundUser);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllAction(  @RequestParam(required = false) String userName){
        List<User> users = userService.findAll(userName);
        return ResponseEntity.ok(users);
    }


}
