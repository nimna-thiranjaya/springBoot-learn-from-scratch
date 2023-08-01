package com.nimna.usermanagementtest.controller;

import com.nimna.usermanagementtest.dto.request.UserSaveRequestDTO;
import com.nimna.usermanagementtest.dto.request.UserUpdateDTO;
import com.nimna.usermanagementtest.dto.response.StandardResponse;
import com.nimna.usermanagementtest.dto.response.UserResponseDTO;
import com.nimna.usermanagementtest.exception.InternalServerErrorException;
import com.nimna.usermanagementtest.service.UserService;
import com.nimna.usermanagementtest.util.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<StandardResponse> createUser(@RequestBody @Valid UserSaveRequestDTO userSaveRequestDTO) {
        try {
            UserResponseDTO userResponseDTO = userService.registerUser(userSaveRequestDTO);

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(true, StatusCode.OK.getCode(), "User created successful!", Instant.now(), userResponseDTO),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @PutMapping("update-user")
    public ResponseEntity<StandardResponse> updateUser(@RequestBody UserUpdateDTO userUpdateDTO){
        try {
            UserResponseDTO userResponseDTO = userService.userUpdate(userUpdateDTO);

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(true, StatusCode.OK.getCode(), "User Updated!", Instant.now(), userResponseDTO),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
