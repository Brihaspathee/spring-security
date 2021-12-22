package com.example.springsecurity.service.interfaces;

import com.example.springsecurity.web.model.CustomerDto;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 5:36 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface CustomerService {

    CustomerDto getCustomerById(UUID customerId);
    Set<CustomerDto> getAllCustomers();
    CustomerDto createCustomer(CustomerDto customerDto);
}
