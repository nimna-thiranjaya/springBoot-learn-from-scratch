package com.nimna.securitywithjwt.service;

import com.nimna.securitywithjwt.dto.request.LoginRequestDTO;
import com.nimna.securitywithjwt.dto.response.LoginResponseDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService extends UserDetailsService {
    public LoginResponseDTO userLogin(LoginRequestDTO loginRequestDTO) throws Exception;
}
