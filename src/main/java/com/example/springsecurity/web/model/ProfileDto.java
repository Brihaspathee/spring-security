package com.example.springsecurity.web.model;

import lombok.*;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 1:24 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    private UUID profileId;

    private String paymentMethod;

    private String favoriteVacationLocation;

    private CustomerDto customerDto;

    @Override
    public String toString() {
        return "ProfileDto{" +
                "profileId=" + profileId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", favoriteVacationLocation='" + favoriteVacationLocation + '\'' +
                ", customerDto=" + customerDto +
                '}';
    }
}
