package com.nimna.securitywithjwt.controller;

import com.nimna.securitywithjwt.dto.request.LoginRequestDTO;
import com.nimna.securitywithjwt.service.LoginService;
import com.nimna.securitywithjwt.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public ResponseEntity<StandardResponse> createJWTTokenAndLogin(@RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        System.out.println(loginRequestDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "Success", loginService.userLogin(loginRequestDTO)),
                HttpStatus.OK
        );
    }
}
