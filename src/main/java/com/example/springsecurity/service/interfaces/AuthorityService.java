package com.example.springsecurity.service.interfaces;

import com.example.springsecurity.exception.AuthorityNotFoundException;
import com.example.springsecurity.web.model.AuthorityDto;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 4:43 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface AuthorityService {

    AuthorityDto getAuthorityById(UUID authorityId) throws AuthorityNotFoundException;
    Set<AuthorityDto> getAllAuthorities();
    AuthorityDto createAuthority(AuthorityDto authorityDto);
}
