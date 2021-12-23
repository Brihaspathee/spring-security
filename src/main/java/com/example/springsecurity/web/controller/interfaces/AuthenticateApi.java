package com.example.springsecurity.web.controller.interfaces;

import com.example.springsecurity.permissions.security.AuthorityCreatePermission;
import com.example.springsecurity.web.model.AuthenticationRequest;
import com.example.springsecurity.web.model.AuthenticationResponse;
import com.example.springsecurity.web.model.AuthorityDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 23, December 2021
 * Time: 6:06 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/authenticate")
public interface AuthenticateApi {

    @PostMapping
    ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception;
}
