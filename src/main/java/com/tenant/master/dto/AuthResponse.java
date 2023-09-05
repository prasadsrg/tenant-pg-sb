package com.tenant.master.dto;

import lombok.Data;

import java.io.Serializable;


@Data
public class AuthResponse implements Serializable {

    private String userName;
    private String token;

    public AuthResponse(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

}
