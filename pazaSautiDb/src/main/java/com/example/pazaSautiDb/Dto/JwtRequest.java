package com.example.pazaSautiDb.Dto;

import lombok.Data;

@Data
public class JwtRequest {
    private String userName;
    private String password;
}