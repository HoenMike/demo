package com.example.demo.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankResponse {
    private String responeCode;
    private String responeMessage;
    private AccountInfo AccountInfo;
}
