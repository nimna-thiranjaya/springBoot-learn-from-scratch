package com.nimna.usermanagementtest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserUpdateDTO {
    private  String email;
    private String firstName;
    private String lastName;

}
