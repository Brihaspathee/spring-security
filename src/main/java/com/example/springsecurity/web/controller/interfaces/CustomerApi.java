package com.example.springsecurity.web.controller.interfaces;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.permissions.customer.CustomerCreatePermission;
import com.example.springsecurity.permissions.customer.CustomerReadPermission;
import com.example.springsecurity.web.model.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 6:31 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/customer")
public interface CustomerApi {

    @GetMapping
    @CustomerReadPermission
    ResponseEntity getCustomer(@AuthenticationPrincipal User user);

    @PostMapping
    @CustomerCreatePermission
    ResponseEntity createCustomer(@RequestBody CustomerDto customerDto);


}
