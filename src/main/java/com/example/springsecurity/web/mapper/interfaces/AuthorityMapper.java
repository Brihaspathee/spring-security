package com.example.springsecurity.web.mapper.interfaces;

import com.example.springsecurity.domain.security.Authority;
import com.example.springsecurity.web.model.AuthorityDto;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:09 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface AuthorityMapper {

    AuthorityDto authorityToAuthorityDto(Authority authority);
    Authority authorityDtoToAuthority(AuthorityDto authorityDto);

    Set<AuthorityDto> authoritiesToAuthorityDTOs(Set<Authority> authorities);

    Set<Authority> authorityDtosToAuthorities(Set<AuthorityDto> authorityDtos);
}
