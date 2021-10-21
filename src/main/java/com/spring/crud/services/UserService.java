package com.spring.crud.services;

import com.spring.crud.models.UserModel;
import com.spring.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserModel> findAllUsersById() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public UserModel addUser(@RequestBody UserModel user) {
        return userRepository.save(user);
    }

    public Optional<UserModel> getUserById(@PathVariable Long id){
        return userRepository.findById(id);
    }

    public void deleteUserID(@PathVariable Long id){
        userRepository.deleteById(id);
    }

    public UserModel putUser(@RequestBody UserModel user){
        return userRepository.save(user);
    }
}
