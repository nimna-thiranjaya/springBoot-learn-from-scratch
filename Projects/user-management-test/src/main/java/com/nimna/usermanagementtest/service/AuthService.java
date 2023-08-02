package com.nimna.usermanagementtest.service;

import com.nimna.usermanagementtest.dto.request.LoginRequestDTO;
import com.nimna.usermanagementtest.dto.response.LoginResponseDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService {
    LoginResponseDTO userLogin(LoginRequestDTO loginRequestDTO) throws Exception;

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
