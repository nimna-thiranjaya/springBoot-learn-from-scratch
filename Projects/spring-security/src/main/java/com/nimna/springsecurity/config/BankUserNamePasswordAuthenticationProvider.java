package com.nimna.springsecurity.config;

import com.nimna.springsecurity.model.User;
import com.nimna.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BankUserNamePasswordAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        List<User> users = userRepo.getUsersByEmail(userName);
        if(users.size() > 0){
           if(passwordEncoder.matches(password, users.get(0).getPassword())){
               List<GrantedAuthority> authorities = new ArrayList<>();
               authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));

               return new UsernamePasswordAuthenticationToken(userName, password, authorities);
           }else{
               throw new BadCredentialsException("Invalid password");
           }
        }else {
            throw new BadCredentialsException("Nor user from given email");
        }
        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
