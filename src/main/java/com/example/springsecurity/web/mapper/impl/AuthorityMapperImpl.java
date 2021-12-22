package com.example.springsecurity.web.mapper.impl;

import com.example.springsecurity.domain.security.Authority;
import com.example.springsecurity.domain.security.Role;
import com.example.springsecurity.web.mapper.interfaces.AuthorityMapper;
import com.example.springsecurity.web.model.AuthorityDto;
import com.example.springsecurity.web.model.RoleDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:10 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Component
public class AuthorityMapperImpl implements AuthorityMapper {
    @Override
    public AuthorityDto authorityToAuthorityDto(Authority authority) {
        if(authority == null){
            return null;
        }
        AuthorityDto authorityDto = AuthorityDto.builder()
                .authorityId(authority.getAuthorityId())
                .permission(authority.getPermission())
                .build();
        if(authority.getRoles() != null &&
                !authority.getRoles().isEmpty()){
            authorityDto.setRoleDtos(authority.getRoles()
                    .stream()
                    .map(role -> RoleDto.builder()
                            .roleId(role.getRoleId())
                            .roleName(role.getRoleName())
                            .build())
                    .collect(Collectors.toSet()));
        }

        return authorityDto;
    }

    @Override
    public Authority authorityDtoToAuthority(AuthorityDto authorityDto) {
        if(authorityDto == null){
            return null;
        }
        Authority authority = Authority.builder()
                .authorityId(authorityDto.getAuthorityId())
                .permission(authorityDto.getPermission())
                .build();
        if(authorityDto.getRoleDtos() != null &&
                !authorityDto.getRoleDtos().isEmpty()){
            authority.setRoles(authorityDto.getRoleDtos()
                    .stream()
                    .map(role -> Role.builder()
                            .roleId(role.getRoleId())
                            .roleName(role.getRoleName())
                            .build())
                    .collect(Collectors.toSet()));
        }

        return authority;
    }

    @Override
    public Set<AuthorityDto> authoritiesToAuthorityDTOs(Set<Authority> authorities) {
        return authorities.stream()
                .map(authority -> authorityToAuthorityDto(authority))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<Authority> authorityDtosToAuthorities(Set<AuthorityDto> authorityDtos) {
        return authorityDtos.stream()
                .map(authorityDto -> authorityDtoToAuthority(authorityDto))
                .collect(Collectors.toSet());
    }
}
