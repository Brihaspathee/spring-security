package com.example.springsecurity.web.mapper.impl;

import com.example.springsecurity.domain.entity.Profile;
import com.example.springsecurity.web.mapper.interfaces.ProductMapper;
import com.example.springsecurity.web.mapper.interfaces.ProfileMapper;
import com.example.springsecurity.web.model.ProfileDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:33 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Component
public class ProfileMapperImpl implements ProfileMapper {
    @Override
    public Profile profileDtoToProfile(ProfileDto profileDto) {
        if (profileDto == null){
            return null;
        }
        Profile profile = Profile.builder()
                .profileId(profileDto.getProfileId())
                .paymentMethod(profileDto.getPaymentMethod())
                .favoriteVacation(profileDto.getFavoriteVacationLocation())
                .build();
        return profile;
    }

    @Override
    public ProfileDto profileToProfileDto(Profile profile) {
        if(profile == null){
            return null;
        }
        ProfileDto profileDto = ProfileDto.builder()
                .profileId(profile.getProfileId())
                .paymentMethod(profile.getPaymentMethod())
                .favoriteVacationLocation(profile.getFavoriteVacation())
                .build();
        return profileDto;
    }

    @Override
    public Set<Profile> profileDtosToProfile(Set<ProfileDto> profileDtos) {
        return profileDtos.stream().map(this::profileDtoToProfile).collect(Collectors.toSet());
    }

    @Override
    public Set<ProfileDto> profilesToProfileDtos(Set<Profile> profiles) {
        return profiles.stream().map(this::profileToProfileDto).collect(Collectors.toSet());
    }
}
