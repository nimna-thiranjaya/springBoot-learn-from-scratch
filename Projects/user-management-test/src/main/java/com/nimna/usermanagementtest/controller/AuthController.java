package com.nimna.usermanagementtest.controller;

import com.nimna.usermanagementtest.dto.request.LoginRequestDTO;
import com.nimna.usermanagementtest.dto.response.LoginResponseDTO;
import com.nimna.usermanagementtest.dto.response.StandardResponse;
import com.nimna.usermanagementtest.service.AuthService;
import com.nimna.usermanagementtest.util.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    private ResponseEntity<StandardResponse> userLogin(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception{
        LoginResponseDTO loginResponseDTO = authService.userLogin(loginRequestDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, StatusCode.OK.getCode(), "Login Success!", Instant.now(), loginResponseDTO ),
                HttpStatus.OK
        );
    }
}
