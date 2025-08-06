package com.TestBirds.project_service.service;

import com.TestBirds.project_service.model.User;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IService<User> {

    public User save( User gen) {
        return gen;
    }
}
