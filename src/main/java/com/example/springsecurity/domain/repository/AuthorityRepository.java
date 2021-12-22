package com.example.springsecurity.domain.repository;

import com.example.springsecurity.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 1:20 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, UUID> {
}
