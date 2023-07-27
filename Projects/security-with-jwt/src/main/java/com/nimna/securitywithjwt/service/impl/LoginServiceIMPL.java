package com.nimna.securitywithjwt.service.impl;

import com.nimna.securitywithjwt.dto.request.LoginRequestDTO;
import com.nimna.securitywithjwt.dto.response.LoginResponseDTO;
import com.nimna.securitywithjwt.entity.Role;
import com.nimna.securitywithjwt.entity.User;
import com.nimna.securitywithjwt.repository.UserRepo;
import com.nimna.securitywithjwt.service.LoginService;
import com.nimna.securitywithjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LoginServiceIMPL implements LoginService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public LoginResponseDTO userLogin(LoginRequestDTO loginRequestDTO) throws Exception {
        String username = loginRequestDTO.getUserName();
        String userPassword = loginRequestDTO.getPassword();

        authenticate(username, userPassword);

        UserDetails userDetails = loadUserByUsername(username);

        String generatedToken = jwtUtil.generateToken(userDetails);

        User user = userRepo.findById(username).get();

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(
                user,
                generatedToken
        );
        return loginResponseDTO;
    }

    private void authenticate(String username, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        }catch (BadCredentialsException e) {
            throw new Exception("INVALID CREDENTIAL", e);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findById(username).get();

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }

        return authorities;
    }
}
