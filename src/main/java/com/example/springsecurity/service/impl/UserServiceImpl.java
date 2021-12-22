package com.example.springsecurity.service.impl;

import com.example.springsecurity.domain.repository.UserRepository;
import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.service.interfaces.RoleService;
import com.example.springsecurity.service.interfaces.UserService;
import com.example.springsecurity.web.mapper.interfaces.UserMapper;
import com.example.springsecurity.web.model.RoleDto;
import com.example.springsecurity.web.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 10:51 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setPassword("{bcrypt}"+bCryptPasswordEncoder.encode(userDto.getPassword()));
        Set<RoleDto> roleDtos = userDto.getRoleDtos().stream().map(roleDto -> {
           String roleName = roleDto.getRoleName();
           RoleDto roleDto1 = roleService.getRolebyRoleName(roleName);
           return roleDto1;
        }).collect(Collectors.toSet());
        userDto.setRoleDtos(roleDtos);
        User user = userMapper.userDtoToUser(userDto);
        user = userRepository.save(user);
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto getUserById(UUID userId) {
        return null;
    }

    @Override
    public Set<UserDto> getAllUsers() {
        return null;
    }
}
