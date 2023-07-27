package com.nimna.securitywithjwt.dto.response;

import com.nimna.securitywithjwt.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LoginResponseDTO {
    private User user;
    private String jwtToken;
}
