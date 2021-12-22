package com.example.springsecurity.service.impl;

import com.example.springsecurity.domain.repository.RoleRepository;
import com.example.springsecurity.domain.security.Role;
import com.example.springsecurity.service.interfaces.RoleService;
import com.example.springsecurity.web.mapper.interfaces.RoleMapper;
import com.example.springsecurity.web.model.RoleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 11:17 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    private final RoleMapper roleMapper;

    @Override
    public RoleDto getRolebyRoleName(String roleName) {
        Role role = roleRepository.findRoleByRoleName(roleName).orElseThrow();
        return roleMapper.roleToRoleDto(role);
    }
}
