package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AccountInfo;
import com.example.demo.dto.BankResponse;
import com.example.demo.dto.PrimaryInfo;
import com.example.demo.dto.UserRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.utils.AccountUtilis;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public BankResponse createAccount(UserRequest userRequest) {

        if(userRepository.existsByEmail(userRequest.getEmail())) {
            return  BankResponse.builder()
                    .responeCode(AccountUtilis.ACCOUNT_EXISTS_CODE)
                    .responeCode(AccountUtilis.ACCOUNT_EXISTS_MESSAGE)
                    .AccountInfo(null)
                    .build();
        }

        User newUser = User.builder()
                        .firstName(userRequest.getFirstName())
                        .lastName(userRequest.getLastName())
                        .otherName(userRequest.getOtherName())
                        .address(userRequest.getAddress())
                        .sateOfOrigin(userRequest.getSateOfOrigin())
                        .accountNumber(AccountUtilis.generateAccountNumber())
                        .accountBalance(BigDecimal.ZERO)
                        .phoneNumber(userRequest.getPhoneNumber())
                        .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                        .email(userRequest.getEmail())
                        .status("ACTIVE")
                        .build();

        User savedUser = userRepository.save(newUser);
        AccountInfo accountInfo = AccountInfo.builder()
                                .accountBalance(savedUser.getAccountBalance())
                                .accountNumber(savedUser.getAccountNumber())
                                .accountName(savedUser.getFirstName() + " " + savedUser.getLastName() + " " + savedUser.getOtherName())
                                .build();

        return BankResponse.builder()
                .responeCode(AccountUtilis.ACCOUNT_CREATION_SUCCESS_CODE)
                .responeMessage(AccountUtilis.ACCOUNT_CREATION_SUCCESS_MASSAGE)
                .AccountInfo(accountInfo)
                .build();
    }
    @Override
    public List<PrimaryInfo> getAllAccount(){
        List<PrimaryInfo> pUsers = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (int i = 0; i < users.size(); i++){
            PrimaryInfo pUser = PrimaryInfo.builder()
                                .id(users.get(i).getId())
                                .fullName(users.get(i).getFirstName() + " "+
                                users.get(i).getOtherName() + " " +
                                users.get(i).getLastName())
                                .build();
            pUsers.add(pUser);
        }
        return pUsers;
    }
    @Override
    public User findUserByID(Long id){
        return userRepository.findById(id).orElse(null);
    }
    @Override
    public BankResponse updateUser(Long id, UserRequest userRequest) {
        User existingUser = userRepository.findById(id).orElse(null);
        
        // Check if the user exists
        if (existingUser == null) {
            return BankResponse.builder()
                    .responeCode(AccountUtilis.ACCOUNT_NOT_EXIST_CODE)
                    .responeMessage(AccountUtilis.ACCOUNT_NOT_EXIST_MESSAGE)
                    .AccountInfo(null)
                    .build();
        }

        existingUser.setFirstName(userRequest.getFirstName());
        existingUser.setLastName(userRequest.getLastName());
        existingUser.setOtherName(userRequest.getOtherName());
        existingUser.setAddress(userRequest.getAddress());
        existingUser.setSateOfOrigin(userRequest.getSateOfOrigin());
        existingUser.setPhoneNumber(userRequest.getPhoneNumber());
        existingUser.setAlternativePhoneNumber(userRequest.getAlternativePhoneNumber());
        existingUser.setEmail(userRequest.getEmail());

        User updatedUser = userRepository.save(existingUser);

        AccountInfo accountInfo = AccountInfo.builder()
                .accountBalance(updatedUser.getAccountBalance())
                .accountNumber(updatedUser.getAccountNumber())
                .accountName(updatedUser.getFirstName() + " " + updatedUser.getLastName() + " " + updatedUser.getOtherName())
                .build();

        return BankResponse.builder()
                .responeCode(AccountUtilis.ACCOUNT_UPDATE_SUCCESS_CODE)
                .responeMessage(AccountUtilis.ACCOUNT_UPDATE_SUCCESS_MESSAGE)
                .AccountInfo(accountInfo)
                .build();
    }
    @Override
    public BankResponse deleteUserByID(Long id){
        User u = userRepository.findById(id).orElse(null);
        if (u == null){
            return BankResponse.builder()
                    .responeCode(AccountUtilis.ACCOUNT_NOT_EXIST_CODE)
                    .responeMessage(AccountUtilis.ACCOUNT_NOT_EXIST_MESSAGE)
                    .AccountInfo(null)
                    .build();
        }
        userRepository.deleteById(id);
        return BankResponse.builder()
                .responeCode(AccountUtilis.ACCOUNT_DELETE_SUCCESS_CODE)
                .responeMessage(AccountUtilis.ACCOUNT_DELETE_SUCCESS_MESSAGE)
                .build();
    }

}
