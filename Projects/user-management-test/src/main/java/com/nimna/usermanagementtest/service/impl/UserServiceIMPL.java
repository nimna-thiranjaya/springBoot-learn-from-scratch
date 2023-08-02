package com.nimna.usermanagementtest.service.impl;

import com.nimna.usermanagementtest.dto.request.UserSaveRequestDTO;
import com.nimna.usermanagementtest.dto.request.UserUpdateDTO;
import com.nimna.usermanagementtest.dto.response.UserResponseDTO;
import com.nimna.usermanagementtest.entity.Role;
import com.nimna.usermanagementtest.entity.User;
import com.nimna.usermanagementtest.exception.BadRequestException;
import com.nimna.usermanagementtest.exception.NotFoundException;
import com.nimna.usermanagementtest.repository.RoleRepository;
import com.nimna.usermanagementtest.repository.UserRepository;
import com.nimna.usermanagementtest.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO registerUser(UserSaveRequestDTO userSaveRequestDTO) {
        if(userRepository.existsById(userSaveRequestDTO.getEmail())){
            throw new BadRequestException("Email already exist!");
        }

        User newUser = modelMapper.map(userSaveRequestDTO, User.class);
        newUser.setPassword(getEncoderPassword(userSaveRequestDTO.getPassword()));
        newUser.setActive(true);

        Set<Role> userRole = new HashSet<>();

        for (String role: userSaveRequestDTO.getRoles()) {
            if(roleRepository.existsById(role)){
                Role roleData = roleRepository.getReferenceById(role);
                userRole.add(roleData);
            }else {
                throw new BadRequestException("Please add valid role names!");
            }
        }
        newUser.setRoles(userRole);

        User creatdUser = userRepository.save(newUser);

        ArrayList<String> userRoles = new ArrayList<>();
        for (Role role: creatdUser.getRoles()) {
            userRoles.add(role.getRoleName());
        }

        UserResponseDTO userResponseDTO = modelMapper.map(creatdUser, UserResponseDTO.class);
        userResponseDTO.setRoles(userRoles);

        return userResponseDTO;
    }

    @Override
    public UserResponseDTO userUpdate(UserUpdateDTO userUpdateDTO) {
        if(userRepository.existsById(userUpdateDTO.getEmail())){
            User updateUser = userRepository.getReferenceById(userUpdateDTO.getEmail());

            updateUser.setFirstName(userUpdateDTO.getFirstName());
            updateUser.setLastName(userUpdateDTO.getLastName());

            User updatedUser = userRepository.save(updateUser);

            return modelMapper.map(updatedUser, UserResponseDTO.class);
        }else{
            throw new NotFoundException("User not found");
        }
    }

    public String getEncoderPassword(String password){
        return passwordEncoder.encode(password);
    }

}
