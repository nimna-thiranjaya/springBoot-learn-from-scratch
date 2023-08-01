package com.nimna.usermanagementtest.controller;

import com.nimna.usermanagementtest.dto.request.RoleSaveRequestDTO;
import com.nimna.usermanagementtest.dto.response.RoleResponseDTO;
import com.nimna.usermanagementtest.dto.response.StandardResponse;
import com.nimna.usermanagementtest.exception.InternalServerErrorException;
import com.nimna.usermanagementtest.service.RoleService;
import com.nimna.usermanagementtest.util.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping(
            path = "save"
    )
    private ResponseEntity<StandardResponse> registerRole(@Valid @RequestBody RoleSaveRequestDTO roleSaveRequestDTO) {
        try {
            RoleResponseDTO roleResponseDTO = roleService.saveRole(roleSaveRequestDTO);

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(true, StatusCode.CREATED.getCode(), "Role saved successful!", Instant.now(), roleResponseDTO),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    @GetMapping(
            path = "roles"
    )
    public ResponseEntity<StandardResponse> getAllRoles() {
        try {
            List<RoleResponseDTO> roleResponseDTOList = roleService.getAllRoleDetails();

            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(true, StatusCode.OK.getCode(), "", Instant.now(), roleResponseDTOList),
                    HttpStatus.CREATED
            );
        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }
}
