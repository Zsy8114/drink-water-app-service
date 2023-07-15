package com.example.demo.controller.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class loginUserForm {
    private String identity;
    private String password;
}
