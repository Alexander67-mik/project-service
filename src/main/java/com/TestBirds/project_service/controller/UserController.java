package com.TestBirds.project_service.controller;

import com.TestBirds.project_service.dto.UserCreate;
import com.TestBirds.project_service.dto.UserUpdate;
import com.TestBirds.project_service.model.User;
import com.TestBirds.project_service.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RequestMapping("/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping()
    public ResponseEntity<User> createAction(@Valid @RequestBody UserCreate userCreate) {
        User newUser = userService.createOne(userCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getOneAction(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(findOneOr404(id));
    }
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateOneAction(@PathVariable Integer id, @RequestBody UserUpdate data){
        User foundUser = findOneOr404(id);
        User updatedUser = userService.updateOne(data, foundUser);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping()
    public ResponseEntity<List<User>> findAllAction(  @RequestParam(required = false) String userName){
        List<User> users = userService.findAll(userName);
        return ResponseEntity.ok(users);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteOneAction(@PathVariable Integer id) {
       User foundUser = findOneOr404(id);
        userService.deleteOne(foundUser);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    private User findOneOr404(Integer id){
        User foundUser = userService.getOne(id);
        if(foundUser == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return foundUser;
    }
}
