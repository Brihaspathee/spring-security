package com.example.springsecurity.web.model;

import lombok.*;

import java.time.LocalDateTime;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 23, December 2021
 * Time: 6:08 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {

    private String jwt;

    private LocalDateTime expiration;

    @Override
    public String toString() {
        return "AuthenticationResponse{" +
                "jwt='" + jwt + '\'' +
                ", expiration=" + expiration +
                '}';
    }
}
