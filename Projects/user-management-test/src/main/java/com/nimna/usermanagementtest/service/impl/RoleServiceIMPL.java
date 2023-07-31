package com.nimna.usermanagementtest.service.impl;

import com.nimna.usermanagementtest.dto.request.RoleSaveRequestDTO;
import com.nimna.usermanagementtest.dto.response.RoleResponseDTO;
import com.nimna.usermanagementtest.entity.Role;
import com.nimna.usermanagementtest.exception.BadRequestException;
import com.nimna.usermanagementtest.repository.RoleRepository;
import com.nimna.usermanagementtest.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceIMPL implements RoleService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleResponseDTO saveRole(RoleSaveRequestDTO roleSaveRequestDTO) {
        if(roleRepository.existsById(roleSaveRequestDTO.getRoleName())){
            throw new BadRequestException("Role already exist!");
        }

        Role role = modelMapper.map(roleSaveRequestDTO, Role.class);
        role.setRoleStatus(1); // 1- active, 2- inactive, 3 -deleted

        Role newRole = roleRepository.save(role);
        RoleResponseDTO roleResponseDTO = modelMapper.map(newRole, RoleResponseDTO.class);

        return roleResponseDTO;
    }
}
