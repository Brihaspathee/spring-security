package com.example.springsecurity.web.mapper.interfaces;

import com.example.springsecurity.domain.entity.Customer;
import com.example.springsecurity.web.model.CustomerDto;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:27 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);

    Set<Customer> customerDtosToCustomers(Set<CustomerDto> customerDtos);
    Set<CustomerDto> customersToCustomerDtos(Set<Customer> customers);
}
