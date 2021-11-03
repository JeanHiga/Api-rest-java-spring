package com.spring.crud.dto;

import com.spring.crud.models.UserModel;

import java.io.Serializable;

public class userDTO implements Serializable {

    private Long id;
    private String name;

    public userDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public userDTO(UserModel userModel){
        id = userModel.getId();
        name = userModel.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
