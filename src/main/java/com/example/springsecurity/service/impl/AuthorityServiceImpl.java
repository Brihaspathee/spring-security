package com.example.springsecurity.service.impl;

import com.example.springsecurity.domain.repository.AuthorityRepository;
import com.example.springsecurity.domain.security.Authority;
import com.example.springsecurity.exception.AuthorityNotFoundException;
import com.example.springsecurity.service.interfaces.AuthorityService;
import com.example.springsecurity.web.mapper.interfaces.AuthorityMapper;
import com.example.springsecurity.web.model.AuthorityDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 4:45 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    private final AuthorityMapper authorityMapper;

    @Override
    public AuthorityDto getAuthorityById(UUID authorityId) throws AuthorityNotFoundException {
        Authority authority = authorityRepository.findById(authorityId)
                .orElseThrow(() -> new AuthorityNotFoundException("Authority with authority Id " + authorityId + " not found exception"));
        return authorityMapper.authorityToAuthorityDto(authority);
    }

    @Override
    public Set<AuthorityDto> getAllAuthorities() {
        Set<Authority> authorities = authorityRepository.findAll().stream().collect(Collectors.toSet());
        return authorityMapper.authoritiesToAuthorityDTOs(authorities);
    }

    @Override
    public AuthorityDto createAuthority(AuthorityDto authorityDto) {
        Authority authority = authorityMapper.authorityDtoToAuthority(authorityDto);
        authority = authorityRepository.save(authority);
        return authorityMapper.authorityToAuthorityDto(authority);
    }
}
