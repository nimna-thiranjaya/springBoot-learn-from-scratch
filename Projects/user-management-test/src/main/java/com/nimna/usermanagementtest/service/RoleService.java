package com.nimna.usermanagementtest.service;

import com.nimna.usermanagementtest.dto.request.RoleSaveRequestDTO;
import com.nimna.usermanagementtest.dto.response.RoleResponseDTO;

public interface RoleService {
    RoleResponseDTO saveRole(RoleSaveRequestDTO roleSaveRequestDTO);
}
