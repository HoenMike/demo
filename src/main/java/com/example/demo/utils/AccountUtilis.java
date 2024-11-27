package com.example.demo.utils;

import java.time.Year;


public class AccountUtilis {

    public static final String ACCOUNT_EXISTS_CODE = "001";
    public static final String ACCOUNT_EXISTS_MESSAGE = "This user already exists!";
    public static final String ACCOUNT_CREATION_SUCCESS_CODE = "002";
    public static final String ACCOUNT_CREATION_SUCCESS_MASSAGE = "Account has been successfully created";
    public static final String ACCOUNT_NOT_EXIST_CODE = "003";
    public static final String ACCOUNT_NOT_EXIST_MESSAGE = "This user does not exists!";
    public static final String ACCOUNT_UPDATE_SUCCESS_CODE = "004";
    public static final String ACCOUNT_UPDATE_SUCCESS_MESSAGE = "Account has been successfully updated";
    public static final String ACCOUNT_DELETE_SUCCESS_CODE = "005";
    public static final String ACCOUNT_DELETE_SUCCESS_MESSAGE = "Account has been successfully deleted";

    public static String generateAccountNumber() {


        // 2023 + randonSixDigits
        Year currentYear = Year.now();

        int min = 100000;
        int max = 999999;

        int randNumber = (int) Math.floor(Math.random() * (max - min + 1));

        String year = String.valueOf(currentYear);
        String randomNumber = String.valueOf(randNumber);
        StringBuilder accountNumber = new StringBuilder();

        return accountNumber
                .append(year)
                .append(randomNumber)
                .toString();
    }

}

