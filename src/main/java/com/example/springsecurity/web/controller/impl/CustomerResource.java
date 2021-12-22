package com.example.springsecurity.web.controller.impl;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.permissions.customer.CustomerCreatePermission;
import com.example.springsecurity.permissions.customer.CustomerReadPermission;
import com.example.springsecurity.service.interfaces.CustomerService;
import com.example.springsecurity.web.controller.interfaces.CustomerApi;
import com.example.springsecurity.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 5:35 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerResource implements CustomerApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity getCustomer(@AuthenticationPrincipal User user){
        if(user.getCustomer() != null){
            CustomerDto customerDto = customerService.getCustomerById(user.getCustomer().getCustomerId());
            return ResponseEntity.ok().body(customerDto);
        }else{
            Set<CustomerDto> customerDtos = customerService.getAllCustomers();
            return ResponseEntity.ok().body(customerDtos);
        }

    }

    @Override
    public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
