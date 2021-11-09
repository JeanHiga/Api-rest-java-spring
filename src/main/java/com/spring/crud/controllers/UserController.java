package com.spring.crud.controllers;

import com.spring.crud.dto.UserDTO;
import com.spring.crud.models.UserModel;
import com.spring.crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping
    public List<UserDTO> userModelList() {
        return userService.findAllUsers();
    }

    @GetMapping("/page") //Retorna usuários paginados
    public List<UserDTO> userPage(Pageable page) {
        return userService.findAllUsersPage(page); //localhost:8080/users/page?page=0&size=2
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserByID(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserModel addUser(@RequestBody UserModel user) {
        return userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return userService.deleteUserID(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> putUser(@PathVariable Long id,@RequestBody UserModel user){
        return userService.putUser(id,user);
    }

}

