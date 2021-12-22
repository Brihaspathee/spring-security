package com.example.springsecurity.web.controller.interfaces;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.permissions.profile.ProfileCreatePermission;
import com.example.springsecurity.web.model.ProfileDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 6:38 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/customer/profile")
public interface CustomerProfileApi {

    @PostMapping
    @ProfileCreatePermission
    ResponseEntity createProfile(@AuthenticationPrincipal User user, @RequestBody ProfileDto profileDto);
}
