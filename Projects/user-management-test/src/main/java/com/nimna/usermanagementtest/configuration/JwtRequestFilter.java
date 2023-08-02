package com.nimna.usermanagementtest.configuration;

import com.nimna.usermanagementtest.exception.ExpiredJwtException;
import com.nimna.usermanagementtest.exception.InvalidJwtException;
import com.nimna.usermanagementtest.service.AuthService;
import com.nimna.usermanagementtest.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String token = null;

        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")){
            token = requestTokenHeader.substring(7);

            try{
                username = jwtUtil.getUserNameFromToken(token);
            }catch (IllegalArgumentException e){
                throw new InvalidJwtException("Unable to get jwt : " + e.getMessage());
            }catch (ExpiredJwtException e){
                throw new ExpiredJwtException("Jwt token is expired : " + e.getMessage());
            }
        }else{
            throw new InvalidJwtException("JWT token is not started with Bearer");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = authService.loadUserByUsername(username);

            if (jwtUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null,userDetails.getAuthorities()
                );

                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
