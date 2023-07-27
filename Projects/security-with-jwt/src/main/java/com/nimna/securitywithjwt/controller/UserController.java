package com.nimna.securitywithjwt.controller;

import com.nimna.securitywithjwt.entity.User;
import com.nimna.securitywithjwt.service.UserService;
import com.nimna.securitywithjwt.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping(path = "register")
    public ResponseEntity<StandardResponse> userRegister(@RequestBody User user){
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", userService.registerUser(user)),
                HttpStatus.CREATED
        );
    }

    @PostConstruct
    public void initROleAndUser(){
        userService.initRoleAndUser();
    }

    @GetMapping("for-admin")
    @PreAuthorize("hasRole('Admin')")
    public String getForAdmin(){
        return "This is admin";
    }
    @GetMapping("for-user")
    @PreAuthorize("hasRole('User')")
    public String getForUser(){
        return "This is User";
    }

    @GetMapping("for-all-role")
    public String AccessForAllUsers(){
        return "This is for all users";
    }

}
