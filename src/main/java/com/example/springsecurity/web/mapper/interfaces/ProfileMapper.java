package com.example.springsecurity.web.mapper.interfaces;

import com.example.springsecurity.domain.entity.Profile;
import com.example.springsecurity.web.model.ProfileDto;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:30 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface ProfileMapper {

    Profile profileDtoToProfile(ProfileDto profileDto);
    ProfileDto profileToProfileDto(Profile profile);

    Set<Profile> profileDtosToProfile(Set<ProfileDto> profileDtos);
    Set<ProfileDto> profilesToProfileDtos(Set<Profile> profiles);
}
