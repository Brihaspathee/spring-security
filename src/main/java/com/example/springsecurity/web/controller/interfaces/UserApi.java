package com.example.springsecurity.web.controller.interfaces;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.permissions.security.RoleCreatePermission;
import com.example.springsecurity.permissions.security.RoleReadPermission;
import com.example.springsecurity.permissions.security.UserCreatePermission;
import com.example.springsecurity.permissions.security.UserReadPermission;
import com.example.springsecurity.web.model.RoleDto;
import com.example.springsecurity.web.model.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 5:01 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/security/user")
public interface UserApi {

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @UserReadPermission
    ResponseEntity getAllUsers(@AuthenticationPrincipal User user);

    @GetMapping("/{userId}")
    @UserReadPermission
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity getUserById(@AuthenticationPrincipal User user, @PathVariable UUID userId);

    @PostMapping
    @UserCreatePermission
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity createUser(@RequestBody UserDto userDto);
}
