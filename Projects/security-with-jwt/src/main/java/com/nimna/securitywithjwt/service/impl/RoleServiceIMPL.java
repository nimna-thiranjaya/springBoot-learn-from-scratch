package com.nimna.securitywithjwt.service.impl;

import com.nimna.securitywithjwt.entity.Role;
import com.nimna.securitywithjwt.repository.RoleRepo;
import com.nimna.securitywithjwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceIMPL implements RoleService {
    @Autowired
    private RoleRepo roleRepo;
    @Override
    public String createRole(Role role) {
        System.out.println(role);
        Role newRole = roleRepo.save(role);
        return "Role Created!";
    }
}
