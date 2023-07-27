package com.nimna.securitywithjwt.controller;

import com.nimna.securitywithjwt.entity.Role;
import com.nimna.securitywithjwt.service.RoleService;
import com.nimna.securitywithjwt.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @PostMapping(path = "create-role")
    public ResponseEntity<StandardResponse> createNewRole(@RequestBody Role role){

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, "Success", roleService.createRole(role)),
                HttpStatus.CREATED
        );
    }
}
