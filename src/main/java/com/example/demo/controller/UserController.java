package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BankResponse;
import com.example.demo.dto.PrimaryInfo;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public BankResponse createAccount(@RequestBody UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }
    @GetMapping("/users")
    public List<PrimaryInfo> getAllUser(){
        return userService.getAllAccount();
    }
    @GetMapping("/user/{id}")
    public User findByID(@PathVariable Long id){
        return userService.findUserByID(id);
    }
    @PutMapping("users/{id}")
    public BankResponse putMethodName(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        return userService.updateUser(id, userRequest);
    }
    @RequestMapping(path="delete_user/{id}", method=RequestMethod.DELETE)
    public BankResponse deleteUserByID(@PathVariable Long id){
        return userService.deleteUserByID(id);
    }
    
}
