package com.example.springsecurity.web.controller.interfaces;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.permissions.product.ProductCreatePermission;
import com.example.springsecurity.permissions.product.ProductReadPermission;
import com.example.springsecurity.permissions.security.AuthorityCreatePermission;
import com.example.springsecurity.permissions.security.AuthorityReadPermission;
import com.example.springsecurity.web.model.AuthorityDto;
import com.example.springsecurity.web.model.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 4:56 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/security/authority")
public interface AuthorityApi {

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @AuthorityReadPermission
    ResponseEntity getAllAuthorities(@AuthenticationPrincipal User user);

    @GetMapping("/{authorityId}")
    @AuthorityReadPermission
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity getAuthorityById(@AuthenticationPrincipal User user, @PathVariable UUID authorityId);

    @PostMapping
    @AuthorityCreatePermission
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity createAuthority(@RequestBody AuthorityDto authorityDto);
}
