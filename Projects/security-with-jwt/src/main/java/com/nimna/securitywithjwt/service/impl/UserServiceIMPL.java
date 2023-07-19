package com.nimna.securitywithjwt.service.impl;

import com.nimna.securitywithjwt.entity.Role;
import com.nimna.securitywithjwt.entity.User;
import com.nimna.securitywithjwt.repository.RoleRepo;
import com.nimna.securitywithjwt.repository.UserRepo;
import com.nimna.securitywithjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        String hashPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPassword);
        return userRepo.save(user);
    }

    @Override
    public void initRoleAndUser() {
        Role Adminrole = new Role();
        if (!roleRepo.existsById("Admin")) {
            Adminrole.setRoleName("Admin");
            Adminrole.setRoleDescription("Admin role");
            roleRepo.save(Adminrole);
        }
        Role Userrole = new Role();
        if (!roleRepo.existsById("User")) {
            Userrole.setRoleName("User");
            Userrole.setRoleDescription("User role");
            roleRepo.save(Userrole);
        }

        if(!userRepo.existsById("admin123")){
            User user = new User();
            user.setUserName("admin123");
            user.setFirstName("Nimna");
            user.setLastName("Thiranjaya");
            user.setPassword(getEncoderPassword("Admin@123"));
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(Adminrole);
            user.setRoles(userRoles);

            System.out.println(user);
            userRepo.save(user);
        }

        if(!userRepo.existsById("user123")){
            User user = new User();
            user.setUserName("user123");
            user.setFirstName("Nimna");
            user.setLastName("Thiranjaya");
            user.setPassword(getEncoderPassword("User@123"));
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(Userrole);
            user.setRoles(userRoles);

            userRepo.save(user);
        }
    }

    public String getEncoderPassword(String password){
        return passwordEncoder.encode(password);
    }
}
