package com.example.springsecurity.service.interfaces;

import com.example.springsecurity.web.model.UserDto;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 10:47 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto getUserById(UUID userId);
    Set<UserDto> getAllUsers();
}
