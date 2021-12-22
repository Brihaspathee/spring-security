package com.example.springsecurity.domain.security;

import com.example.springsecurity.domain.entity.Customer;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 9:52 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.domain.security
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SECURITY_USER")
public class User implements UserDetails, CredentialsContainer {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "user_id", length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID userId;

    private String username;

    private String password;

    @Builder.Default
    private boolean accountNotExpired = true;

    @Builder.Default
    private boolean accountNotLocked = true;

    @Builder.Default
    private boolean credentialsNotExpired = true;

    @Builder.Default
    private boolean enabled = true;

    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER)
    private Customer customer;

    @Singular
    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
                joinColumns = {@JoinColumn(name = "USER_ID")},
                inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")})
    private Set<Role> roles;


    @Override
    public void eraseCredentials() {
        this.password = null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(Role::getAuthorities)
                .flatMap(Set :: stream)
                .map(authority -> {
                    return new SimpleGrantedAuthority(authority.getPermission());
                }).collect(Collectors.toSet());
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNotExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNotLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", customer=" + customer +
                ", roles=" + roles +
                '}';
    }
}
