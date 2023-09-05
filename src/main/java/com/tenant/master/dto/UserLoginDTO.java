package com.tenant.master.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginDTO implements Serializable {

    private String userName;
    private String password;
    private String tenantOrClientId;

}
