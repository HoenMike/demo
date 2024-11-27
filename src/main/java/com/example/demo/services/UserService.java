package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.BankResponse;
import com.example.demo.dto.PrimaryInfo;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;

public interface UserService {
    public BankResponse createAccount(UserRequest userRequest);
    public List<PrimaryInfo> getAllAccount();
    public User findUserByID(Long id);
    public BankResponse updateUser(Long id, UserRequest userRequest);
    public BankResponse deleteUserByID(Long id);
}