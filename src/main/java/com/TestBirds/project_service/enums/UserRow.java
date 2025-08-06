package com.TestBirds.project_service.enums;

public enum UserRow {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    TESTER("ROLE_TESTER"),
    CLIENT("ROLE_CLIENT");


    private final String role;

    UserRow(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
