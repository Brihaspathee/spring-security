package com.example.springsecurity.web.controller.impl;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.web.controller.interfaces.AuthorityApi;
import com.example.springsecurity.web.model.AuthorityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 23, December 2021
 * Time: 3:22 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequiredArgsConstructor
public class AuthorityResource implements AuthorityApi {
    @Override
    public ResponseEntity getAllAuthorities(User user) {
        return null;
    }

    @Override
    public ResponseEntity getAuthorityById(User user, UUID authorityId) {
        return null;
    }

    @Override
    public ResponseEntity createAuthority(AuthorityDto authorityDto) {
        return null;
    }
}
