package com.example.springsecurity.web.controller.interfaces;

import com.example.springsecurity.domain.security.User;
import com.example.springsecurity.permissions.customer.CustomerCreatePermission;
import com.example.springsecurity.permissions.customer.CustomerReadPermission;
import com.example.springsecurity.permissions.product.ProductCreatePermission;
import com.example.springsecurity.permissions.product.ProductReadPermission;
import com.example.springsecurity.web.model.CustomerDto;
import com.example.springsecurity.web.model.ProductDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 3:21 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.controller.interfaces
 * To change this template use File | Settings | File and Code Template
 */
@RequestMapping("/api/v1/product")
public interface ProductApi {

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    @ProductReadPermission
    ResponseEntity getAllProducts(@AuthenticationPrincipal User user);

    @GetMapping("/{productId}")
    @ProductReadPermission
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity getProductById(@AuthenticationPrincipal User user, @PathVariable UUID productId);

    @PostMapping
    @ProductCreatePermission
    @ResponseStatus(value = HttpStatus.CREATED)
    ResponseEntity createProduct(@RequestBody ProductDto productDto);
}
