package com.example.springsecurity.service.impl;

import com.example.springsecurity.domain.entity.Customer;
import com.example.springsecurity.domain.entity.Profile;
import com.example.springsecurity.domain.repository.CustomerRepository;
import com.example.springsecurity.domain.repository.ProfileRepository;
import com.example.springsecurity.exception.CustomerNotFoundException;
import com.example.springsecurity.exception.ProfileAlreadyAvailableException;
import com.example.springsecurity.service.interfaces.CustomerProfileService;
import com.example.springsecurity.service.interfaces.CustomerService;
import com.example.springsecurity.web.mapper.interfaces.ProfileMapper;
import com.example.springsecurity.web.model.ProfileDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 6:43 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerProfileServiceImpl implements CustomerProfileService {

    private final CustomerRepository customerRepository;

    private final ProfileRepository profileRepository;

    private final ProfileMapper profileMapper;

    @Override
    public ProfileDto createProfile(ProfileDto profileDto) {
        Customer customer = customerRepository.findById(profileDto.getCustomerDto().getCustomerId()).orElseThrow(() -> new CustomerNotFoundException("Customer Not Found"));
        if(customer.getProfile() == null){
            Profile profile = profileMapper.profileDtoToProfile(profileDto);
            profile.setCustomer(customer);
            return profileMapper.profileToProfileDto(profileRepository.save(profile));
        }else{
            throw new ProfileAlreadyAvailableException("A profile already exists");
        }
    }
}
