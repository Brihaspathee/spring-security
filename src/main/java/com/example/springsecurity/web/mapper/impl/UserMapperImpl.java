package com.example.springsecurity.web.mapper.impl;

import com.example.springsecurity.domain.security.Role;
import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.web.mapper.interfaces.RoleMapper;
import com.example.springsecurity.web.mapper.interfaces.UserMapper;
import com.example.springsecurity.web.model.RoleDto;
import com.example.springsecurity.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:14 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    private final RoleMapper roleMapper;

    @Override
    public User userDtoToUser(UserDto userDto) {
        if(userDto == null){
            return null;
        }
        User user = User.builder()
                .userId(userDto.getUserId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .build();
        if(userDto.getRoleDtos() != null && !userDto.getRoleDtos().isEmpty()){
            Set<Role> roles = userDto.getRoleDtos().stream().map(roleMapper :: roleDtoToRole).collect(Collectors.toSet());
            user.setRoles(roles);
        }
        return user;
    }

    @Override
    public UserDto userToUserDto(User user) {
        if(user == null){
            return null;
        }
        UserDto userDto = UserDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
        if(user.getRoles() != null && !user.getRoles().isEmpty()){
            Set<RoleDto> roles = user.getRoles().stream().map(roleMapper :: roleToRoleDto).collect(Collectors.toSet());
            userDto.setRoleDtos(roles);
        }
        return userDto;
    }

    @Override
    public Set<User> userDtosToUsers(Set<UserDto> userDtos) {
        return userDtos.stream().map(userDto -> userDtoToUser(userDto)).collect(Collectors.toSet());
    }

    @Override
    public Set<UserDto> usersToUserDtos(Set<User> users) {
        return users.stream().map(user -> userToUserDto(user)).collect(Collectors.toSet());
    }
}
