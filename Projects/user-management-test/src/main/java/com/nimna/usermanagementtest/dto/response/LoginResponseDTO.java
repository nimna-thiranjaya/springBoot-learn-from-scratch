package com.nimna.usermanagementtest.dto.response;

import com.nimna.usermanagementtest.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LoginResponseDTO {
    private UserResponseDTO user;
    private String token;
}
