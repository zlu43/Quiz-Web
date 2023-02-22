package com.example.springmvctemplate.domain;

import lombok.*;

@Data
public class User {
    private int user_id;
    private String user_password;
    private String user_name;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String address;
    private Boolean is_admin;
    private Boolean is_active;
}
