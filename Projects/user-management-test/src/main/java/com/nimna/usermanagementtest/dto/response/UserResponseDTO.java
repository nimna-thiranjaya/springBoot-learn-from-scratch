package com.nimna.usermanagementtest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponseDTO {
    private  String email;
    private String firstName;
    private String lastName;
}
