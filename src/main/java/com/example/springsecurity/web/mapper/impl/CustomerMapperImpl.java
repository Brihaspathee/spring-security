package com.example.springsecurity.web.mapper.impl;

import com.example.springsecurity.domain.entity.Customer;
import com.example.springsecurity.web.mapper.interfaces.CustomerMapper;
import com.example.springsecurity.web.mapper.interfaces.ProfileMapper;
import com.example.springsecurity.web.mapper.interfaces.UserMapper;
import com.example.springsecurity.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:29 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Component
@RequiredArgsConstructor
public class CustomerMapperImpl implements CustomerMapper {

    private final ProfileMapper profileMapper;

    private final UserMapper userMapper;

    @Override
    public Customer customerDtoToCustomer(CustomerDto customerDto) {
        if(customerDto == null){
            return null;
        }
        Customer customer = Customer.builder()
                .customerId(customerDto.getCustomerId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .dateOfBirth(customerDto.getDateOfBirth())
                .maritalStatus(customerDto.getMaritalStatus())
                .gender(customerDto.getGender())
                .user(userMapper.userDtoToUser(customerDto.getUserDto()))
                .profile(profileMapper.profileDtoToProfile(customerDto.getProfileDto()))
                .build();
        return customer;
    }

    @Override
    public CustomerDto customerToCustomerDto(Customer customer) {
        if(customer == null){
            return null;
        }
        CustomerDto customerDto = CustomerDto.builder()
                .customerId(customer.getCustomerId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .dateOfBirth(customer.getDateOfBirth())
                .maritalStatus(customer.getMaritalStatus())
                .gender(customer.getGender())
                .userDto(userMapper.userToUserDto(customer.getUser()))
                .profileDto(profileMapper.profileToProfileDto(customer.getProfile()))
                .build();
        return customerDto;
    }

    @Override
    public Set<Customer> customerDtosToCustomers(Set<CustomerDto> customerDtos) {
        return customerDtos.stream().map(this::customerDtoToCustomer).collect(Collectors.toSet());
    }

    @Override
    public Set<CustomerDto> customersToCustomerDtos(Set<Customer> customers) {
        return customers.stream().map(this::customerToCustomerDto).collect(Collectors.toSet());
    }
}
