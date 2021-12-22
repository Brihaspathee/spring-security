package com.example.springsecurity.exception;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 6:27 AM
 * Project: spring-security
 * Package Name: com.example.springsecurity.exception
 * To change this template use File | Settings | File and Code Template
 */
public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message){
        super(message);
    }

    public CustomerNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
