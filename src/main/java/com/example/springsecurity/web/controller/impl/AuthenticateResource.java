package com.example.springsecurity.web.controller.impl;

import com.example.springsecurity.auth.JpaUserDetailsService;
import com.example.springsecurity.util.JwtUtil;
import com.example.springsecurity.web.controller.interfaces.AuthenticateApi;
import com.example.springsecurity.web.model.AuthenticationRequest;
import com.example.springsecurity.web.model.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 23, December 2021
 * Time: 6:09 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequiredArgsConstructor
public class AuthenticateResource implements AuthenticateApi {

    private final AuthenticationManager authenticationManager;

    private final JpaUserDetailsService userDetailsService;

    private final JwtUtil jwtUtil;

    @Override
    public ResponseEntity<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) throws Exception {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
        }catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        final Date expirationDate = jwtUtil.extractExpiration(jwt);
        final LocalDateTime expiration = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .jwt(jwt)
                .expiration(expiration)
                .build();
        return ResponseEntity.ok(authenticationResponse);
    }
}
