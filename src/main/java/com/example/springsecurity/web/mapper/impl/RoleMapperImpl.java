package com.example.springsecurity.web.mapper.impl;

import com.example.springsecurity.domain.security.Role;
import com.example.springsecurity.web.mapper.interfaces.AuthorityMapper;
import com.example.springsecurity.web.mapper.interfaces.RoleMapper;
import com.example.springsecurity.web.model.RoleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:12 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Component
@RequiredArgsConstructor
public class RoleMapperImpl implements RoleMapper {

    private final AuthorityMapper authorityMapper;

    @Override
    public RoleDto roleToRoleDto(Role role) {
        if(role == null){
            return null;
        }
        RoleDto roleDto = RoleDto.builder()
                .roleId(role.getRoleId())
                .roleName(role.getRoleName())
                .build();
        if(role.getAuthorities()!=null && !role.getAuthorities().isEmpty()){
            roleDto.setAuthorityDtos(role.getAuthorities()
                    .stream()
                    .map(authorityMapper :: authorityToAuthorityDto)
                    .collect(Collectors.toSet()));
        }
        return roleDto;
    }

    @Override
    public Role roleDtoToRole(RoleDto roleDto) {
        if(roleDto == null){
            return null;
        }
        Role role = Role.builder()
                .roleId(roleDto.getRoleId())
                .roleName(roleDto.getRoleName())
                .build();
        if(roleDto.getAuthorityDtos()!=null && !roleDto.getAuthorityDtos().isEmpty()){
            role.setAuthorities(roleDto.getAuthorityDtos()
                    .stream()
                    .map(authorityMapper :: authorityDtoToAuthority)
                    .collect(Collectors.toSet()));
        }
        return role;
    }

    @Override
    public Set<RoleDto> rolesToRoleDTOs(Set<Role> roles) {
        return roles.stream().map(role -> roleToRoleDto(role)).collect(Collectors.toSet());
    }

    @Override
    public Set<Role> roleDtosToRoles(Set<RoleDto> roleDtos) {
        return roleDtos.stream().map(roleDto -> roleDtoToRole(roleDto)).collect(Collectors.toSet());
    }
}
