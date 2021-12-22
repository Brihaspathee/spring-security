package com.example.springsecurity.permissions.customer;

import org.springframework.security.access.prepost.PreAuthorize;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 3:53 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.permissions.customer
 * To change this template use File | Settings | File and Code Template
 */
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority('customer.create')")
public @interface CustomerCreatePermission {
}
