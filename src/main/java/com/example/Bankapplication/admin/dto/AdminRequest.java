package com.example.Bankapplication.admin.dto;

import lombok.Data;

@Data
public class AdminRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
    private String status;

}