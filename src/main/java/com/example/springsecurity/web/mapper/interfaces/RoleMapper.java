package com.example.springsecurity.web.mapper.interfaces;

import com.example.springsecurity.domain.security.Role;
import com.example.springsecurity.web.model.RoleDto;

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
public interface RoleMapper {

    RoleDto roleToRoleDto(Role role);
    Role roleDtoToRole(RoleDto roleDto);

    Set<RoleDto> rolesToRoleDTOs(Set<Role> roles);

    Set<Role> roleDtosToRoles(Set<RoleDto> roleDtos);
}
