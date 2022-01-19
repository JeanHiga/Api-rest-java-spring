package com.spring.crud.dto;

import com.spring.crud.models.UserModel;

import java.io.Serializable;

public class UserDTO implements Serializable {


    private String name;

    public UserDTO(String name) {

        this.name = name;
    }

    public UserDTO(UserModel userModel){
        name = userModel.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
