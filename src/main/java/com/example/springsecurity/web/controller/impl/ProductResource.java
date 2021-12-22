package com.example.springsecurity.web.controller.impl;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.exception.ProductNotFoundException;
import com.example.springsecurity.service.interfaces.ProductService;
import com.example.springsecurity.web.controller.interfaces.ProductApi;
import com.example.springsecurity.web.model.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 3:24 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ProductResource implements ProductApi {

    private final ProductService productService;

    @Override
    public ResponseEntity getAllProducts(User user) {
        log.info("User is:{}", user.getUsername());
        Set<ProductDto> productDtoSet = productService.getAllProducts();
        return ResponseEntity.ok(productDtoSet);
    }

    @Override
    public ResponseEntity getProductById(User user, UUID productId) {
        log.info("User is:{}", user.getUsername());
        try{
            ProductDto productDto = productService.getProductById(productId);
            return ResponseEntity.ok(productDto);
        }catch (ProductNotFoundException productNotFoundException){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity createProduct(ProductDto productDto) {
        ProductDto productDto1 = productService.createProduct(productDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/v1/product/" + productDto1.getProductId());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }
}
