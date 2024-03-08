package com.example.coursedatabase.app.controller;

import com.example.coursedatabase.app.dto.UserDto;
import com.example.coursedatabase.domain.model.User;
import com.example.coursedatabase.app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @GetMapping
//    public ResponseEntity<List<User>> findAllResponse(){
//        List<User> list = userService.findAllResponse();
//        return ResponseEntity.ok().body(list);
//    }

    @GetMapping
    public List<UserDto> findAll(){
        return userService.findAll();
    }

//    @GetMapping
//    public List<UserDto> response(){
//        return userService.response();
//    }


//    @GetMapping
//    public List<UserDto> find(){
//        return userService.find();
//    }

    @GetMapping(value = "/{id}")
    public UserDto findById(@PathVariable Long id){
//        User obj = userService.findById(id);
//        return ResponseEntity.ok().body(obj);
        return userService.findById(id);
    }

    @PostMapping()
    public User create(@RequestBody User user){
        return userService.create(user);
    }
}