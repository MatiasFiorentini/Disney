package com.alkemy.disney.disney.auth.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @Email(message = "Username must be an email")
    private String username;

    @Size(min = 6)
    @NotNull
    private String password;
}
