package com.nimna.usermanagementtest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserSaveRequestDTO {
    @NotEmpty(message = "Email required!")
    @Email(message = "Invalid email")
    private  String email;

    @NotEmpty(message = "First name required!")
    private String firstName;

    @NotEmpty(message = "Last name required!")
    private String lastName;

    @NotEmpty(message = "Password required!")
    private  String password;

    @NotEmpty(message = "Role required!")
    private ArrayList<String> roles;
}
