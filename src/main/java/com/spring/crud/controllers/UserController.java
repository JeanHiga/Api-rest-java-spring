package com.spring.crud.controllers;

import com.spring.crud.models.UserModel;
import com.spring.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping
    public List<UserModel> userModelList() {
        return userService.findAllUsersById();
    }

    @GetMapping("/{id}")
    public Optional<UserModel> getUserByID(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel addUser(@RequestBody UserModel user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserID(@PathVariable Long id){
        userService.deleteUserID(id);
    }

    @PutMapping
    public UserModel putUser(@RequestBody UserModel user){
        return userService.putUser(user);
    }

}

