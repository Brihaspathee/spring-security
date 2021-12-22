package com.example.springsecurity.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 11:27 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profile {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "profile_id", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID profileId;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "favorite_vacation")
    private String favoriteVacation;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
