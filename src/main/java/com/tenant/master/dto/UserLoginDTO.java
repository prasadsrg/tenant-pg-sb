package com.tenant.master.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class UserLoginDTO implements Serializable {

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    private String tenant;

}
