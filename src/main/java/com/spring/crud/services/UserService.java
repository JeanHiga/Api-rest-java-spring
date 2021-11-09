package com.spring.crud.services;

import com.spring.crud.dto.UserDTO;
import com.spring.crud.models.UserModel;
import com.spring.crud.repository.UserRepository;
import com.spring.crud.repository.UserRepositoryPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryPage userRepositoryPage;

    public List<UserDTO> findAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public List<UserDTO> findAllUsersPage(Pageable page) {
        Page<UserModel> userpage = userRepositoryPage.findAll(page);
        return userpage.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserModel addUser(@RequestBody UserModel user) {
        return userRepository.save(user);
    }

    public ResponseEntity<UserModel> getUserById(@PathVariable Long id){
        Optional<UserModel> user = userRepository.findById(id);

        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Void> deleteUserID(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<UserModel> putUser(@PathVariable Long id, @RequestBody UserModel user){
        if(!userRepository.existsById(id)){
            return  ResponseEntity.notFound().build();
        }
        user.setId(id);
        user = userRepository.save(user);

        return ResponseEntity.ok(user);
    }
}
