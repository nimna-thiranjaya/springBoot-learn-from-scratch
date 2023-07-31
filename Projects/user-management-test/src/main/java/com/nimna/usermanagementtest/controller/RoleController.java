package com.nimna.usermanagementtest.controller;

import com.nimna.usermanagementtest.dto.request.RoleSaveRequestDTO;
import com.nimna.usermanagementtest.dto.response.RoleResponseDTO;
import com.nimna.usermanagementtest.dto.response.StandardResponse;
import com.nimna.usermanagementtest.service.RoleService;
import com.nimna.usermanagementtest.util.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;
    @PostMapping(
            path = "save"
    )
    private ResponseEntity<StandardResponse> registerRole(@RequestBody @Valid RoleSaveRequestDTO roleSaveRequestDTO){
        RoleResponseDTO roleResponseDTO = roleService.saveRole(roleSaveRequestDTO);

        String message = "";
        if(roleResponseDTO.getRoleName() != null) {
            message = "Role Saved Successful!";
        }else {
            message = "Failed to save role!";
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(true, StatusCode.CREATED.getCode(),message, Instant.now(), roleResponseDTO),
                HttpStatus.CREATED
        );
    }
}
