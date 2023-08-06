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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public LoginResponseDTO userLogin(LoginRequestDTO loginRequestDTO) throws Exception {
        String email = loginRequestDTO.getEmail();
        String password = loginRequestDTO.getPassword();
        
        if(email == "" || password == ""){
            throw new BadRequestException("Email and Password required");
        }

        boolean userCheck = userRepository.existsById(email);

        if(userCheck){
            UserDetails userDetails = loadUserByUsername(email);

            authenticate(email, password);

            String token = jwtUtil.generateToken(userDetails);

            User user = userRepository.findById(email).get();

            ArrayList<String> userRoles = new ArrayList<>();
            for (Role role: user.getRoles()) {
                userRoles.add(role.getRoleName());
            }

            UserResponseDTO userResponseDTO = modelMapper.map(user, UserResponseDTO.class);
            userResponseDTO.setRoles(userRoles);

            return new LoginResponseDTO(
                    userResponseDTO,
                    token
            );
        }else {
            throw  new NotFoundException("Invalid Email!");
        }
    }

    private void authenticate(String email, String password) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        }catch (Exception e){
            throw new BadRequestException("Invalid Password!");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findById(username).get();


        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getEmail(),
                    user.getPassword(),
                    getAuthorities(user)
            );
        } else {
            throw new UsernameNotFoundException("Username not found");
        }
    }

    private Set getAuthorities(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });

        return authorities;

    }
}
