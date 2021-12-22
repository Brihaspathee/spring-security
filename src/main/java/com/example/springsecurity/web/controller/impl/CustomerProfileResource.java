package com.example.springsecurity.web.controller.impl;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.service.interfaces.CustomerProfileService;
import com.example.springsecurity.web.controller.interfaces.CustomerProfileApi;
import com.example.springsecurity.web.model.CustomerDto;
import com.example.springsecurity.web.model.ProfileDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 6:40 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class CustomerProfileResource implements CustomerProfileApi {

    private final CustomerProfileService customerProfileService;

    @Override
    public ResponseEntity createProfile(User user, ProfileDto profileDto) {
        if(user.getCustomer()!=null){
            profileDto.setCustomerDto(CustomerDto.builder()
                    .customerId(user.getCustomer().getCustomerId())
                    .build());
            profileDto = customerProfileService.createProfile(profileDto);
            return new ResponseEntity(profileDto, HttpStatus.CREATED);
        }else{
            profileDto = customerProfileService.createProfile(profileDto);
            return new ResponseEntity(profileDto, HttpStatus.CREATED);
        }
    }
}
