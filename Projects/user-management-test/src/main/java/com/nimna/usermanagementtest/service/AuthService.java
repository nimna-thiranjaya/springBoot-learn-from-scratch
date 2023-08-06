package com.nimna.usermanagementtest.service;

import com.nimna.usermanagementtest.dto.request.LoginRequestDTO;
import com.nimna.usermanagementtest.dto.response.LoginResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    LoginResponseDTO userLogin(LoginRequestDTO loginRequestDTO) throws Exception;
}
