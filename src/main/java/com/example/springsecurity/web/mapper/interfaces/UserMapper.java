package com.example.springsecurity.web.mapper.interfaces;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.web.model.UserDto;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:08 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface UserMapper {

    User userDtoToUser(UserDto userDto);
    UserDto userToUserDto(User user);

    Set<User> userDtosToUsers(Set<UserDto> userDtos);
    Set<UserDto> usersToUserDtos(Set<User> users);

}
