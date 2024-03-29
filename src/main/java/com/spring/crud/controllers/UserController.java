package com.spring.crud.controllers;

import com.spring.crud.dto.UserDTO;
import com.spring.crud.models.UserModel;
import com.spring.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping
    public ResponseEntity<Page<UserDTO>> getAllUsers(Pageable page) {
        return userService.findAllUsers(page);//localhost:8080/users/?page=0&size=2
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserByID(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel addUser(@Valid @RequestBody UserModel user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return userService.deleteUserID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> putUser(@Valid @PathVariable Long id,@RequestBody UserModel user){
        return userService.putUser(id,user);
    }
}

