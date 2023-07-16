package com.nimna.springsecurity.controller;

import com.nimna.springsecurity.model.User;
import com.nimna.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    private ResponseEntity<String> registerUser(@RequestBody User user) {
        ResponseEntity response = null;
        try {
            if (!userRepo.existsUserByEmail(user.getEmail())) {
                String hashPassword = passwordEncoder.encode(user.getPassword());

                user.setPassword(hashPassword);

                User savedUser = userRepo.save(user);

                if (savedUser.getId() > 0) {
                    response = ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body("User Created");
                } else {
                    throw new Exception("Error in user Creation");
                }

            } else {
                throw new Exception("Email already exist");
            }

        } catch (Exception e) {
            response = ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
        return response;
    }
}
