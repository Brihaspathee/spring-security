package com.example.springsecurity.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 4:47 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.exception
 * To change this template use File | Settings | File and Code Template
 */
public class RoleNotFoundException extends Exception{

    public RoleNotFoundException(String message){
        super(message);
    }

    public RoleNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
