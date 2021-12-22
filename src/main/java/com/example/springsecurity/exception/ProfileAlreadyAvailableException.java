package com.example.springsecurity.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 6:41 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.exception
 * To change this template use File | Settings | File and Code Template
 */
public class ProfileAlreadyAvailableException extends RuntimeException{

    public ProfileAlreadyAvailableException(String message){
        super(message);
    }

    public ProfileAlreadyAvailableException(String message, Throwable cause){
        super(message, cause);
    }
}
