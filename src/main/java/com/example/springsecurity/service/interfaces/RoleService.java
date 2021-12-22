package com.example.springsecurity.service.interfaces;

import com.example.springsecurity.web.model.RoleDto;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 11:16 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface RoleService {

    RoleDto getRolebyRoleName(String roleName);
}
