package com.example.springsecurity.web.model;

import com.example.springsecurity.domain.Gender;
import com.example.springsecurity.domain.MaritalStatus;
import lombok.*;

import java.time.LocalDate;
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
public class CustomerDto {

    private UUID customerId;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private MaritalStatus maritalStatus;

    private Gender gender;

    private UserDto userDto;

    private ProfileDto profileDto;

    @Override
    public String toString() {
        return "CustomerDto{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", maritalStatus=" + maritalStatus +
                ", gender=" + gender +
                '}';
    }
}
