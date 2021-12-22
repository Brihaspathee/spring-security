package com.example.springsecurity.web.controller.interfaces;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.permissions.security.AuthorityCreatePermission;
import com.example.springsecurity.permissions.security.AuthorityReadPermission;
import com.example.springsecurity.permissions.security.RoleCreatePermission;
import com.example.springsecurity.permissions.security.RoleReadPermission;
import com.example.springsecurity.web.model.AuthorityDto;
import com.example.springsecurity.web.model.RoleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 4:59 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/security/role")
public interface RoleApi {

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @RoleReadPermission
    ResponseEntity getAllRoles(@AuthenticationPrincipal User user);

    @GetMapping("/{roleId}")
    @RoleReadPermission
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity getRoleById(@AuthenticationPrincipal User user, @PathVariable UUID roleId);

    @PostMapping
    @RoleCreatePermission
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity createRole(@RequestBody RoleDto roleDto);
}
