package com.alkemy.disney.disney.auth.dto;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserDTO {

    private String username;

    @NotNull
    private String password;
}
