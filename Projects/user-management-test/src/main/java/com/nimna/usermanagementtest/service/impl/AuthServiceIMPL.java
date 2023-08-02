package com.nimna.usermanagementtest.service.impl;

import com.nimna.usermanagementtest.dto.request.LoginRequestDTO;
import com.nimna.usermanagementtest.dto.response.LoginResponseDTO;
import com.nimna.usermanagementtest.dto.response.UserResponseDTO;
import com.nimna.usermanagementtest.entity.Role;
import com.nimna.usermanagementtest.entity.User;
import com.nimna.usermanagementtest.exception.BadRequestException;
import com.nimna.usermanagementtest.exception.NotFoundException;
import com.nimna.usermanagementtest.repository.UserRepository;
import com.nimna.usermanagementtest.service.AuthService;
import com.nimna.usermanagementtest.util.JwtUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceIMPL implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public LoginResponseDTO userLogin(LoginRequestDTO loginRequestDTO) throws Exception {
        String username = loginRequestDTO.getEmail();
        String password= loginRequestDTO.getPassword();

        if(username == null || password == null ){
            throw new BadRequestException("Please provide email and password");
        }

        authenticate(username, password);

        UserDetails userDetails = loadUserByUsername(username);

        String generatedToken = jwtUtil.generateToken(userDetails);

        User user = userRepository.findById(username).get();

        UserResponseDTO userResponseDTO =  modelMapper.map(user, UserResponseDTO.class);

        ArrayList<String> roles = new ArrayList<>();
        for (Role role: user.getRoles()) {
            roles.add(role.getRoleName());
        }

        userResponseDTO.setRoles(roles);

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(
                userResponseDTO,
                generatedToken
        );

        return loginResponseDTO;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new NotFoundException("User not found with email: " + username);
        }
    }

    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return authorities;
    }

    private void authenticate(String username, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (BadCredentialsException e) {
            throw new BadRequestException("Invalid Credentials!");
        }
    }

}
