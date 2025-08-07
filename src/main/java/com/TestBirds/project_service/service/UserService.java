package com.TestBirds.project_service.service;

import com.TestBirds.project_service.dto.UserCreate;
import com.TestBirds.project_service.enums.UserRow;
import com.TestBirds.project_service.model.User;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IService<User> {

    public User save( User gen) {
        return gen;
    }
    public User getOne(int id){
        if (id != 1){
            return null;
        }
        User newUser = new User();
        newUser.setId(id);
        newUser.setUsername("Alexander");
        newUser.setLanguage("bg");
        newUser.setRoles(List.of(UserRow.ADMIN, UserRow.USER));
        return newUser;

    }
    public User updateOne(User obj){
        return obj;
    }
    public List<User> findAll(String userName){
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setId(1);
        user1.setUsername("Alexander");
        user1.setLanguage("bg");
        user1.setRoles(List.of(UserRow.ADMIN, UserRow.USER));
        user2.setId(2);
        user2.setUsername("Ivan");
        user2.setLanguage("eng");
        user2.setRoles(List.of(UserRow.USER, UserRow.TESTER));
        user3.setId(3);
        user3.setUsername("Gosho");
        user3.setLanguage("ger");
        user3.setRoles(List.of(UserRow.USER, UserRow.CLIENT));
        List<User> users = List.of(user1, user2, user3);
        if(userName == null){
            return users;
        }
        return users.stream().filter(u -> u.getUsername().equals(userName)).toList();
    }
    public void deleteOne(User del){

    }

    public User createOne(UserCreate cr){
        return null;
    }
}
