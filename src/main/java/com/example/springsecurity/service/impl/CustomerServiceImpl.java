package com.example.springsecurity.service.impl;

import com.example.springsecurity.domain.entity.Customer;
import com.example.springsecurity.domain.repository.CustomerRepository;
import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.exception.CustomerNotFoundException;
import com.example.springsecurity.service.interfaces.CustomerService;
import com.example.springsecurity.service.interfaces.UserService;
import com.example.springsecurity.web.mapper.interfaces.CustomerMapper;
import com.example.springsecurity.web.model.CustomerDto;
import com.example.springsecurity.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 5:36 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    private final UserService userService;

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->  new CustomerNotFoundException("Customer not found"));
        return customerMapper.customerToCustomerDto(customer);
    }

    @Override
    public Set<CustomerDto> getAllCustomers() {
        Set<Customer> customers = customerRepository.findAll().stream().collect(Collectors.toSet());
        return customerMapper.customersToCustomerDtos(customers);
    }

    @Transactional
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        UserDto userDto = userService.createUser(customerDto.getUserDto());
        customerDto.getUserDto().setUserId(userDto.getUserId());
        Customer customer = customerMapper.customerDtoToCustomer(customerDto);
        customer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDto(customer);
    }
}
