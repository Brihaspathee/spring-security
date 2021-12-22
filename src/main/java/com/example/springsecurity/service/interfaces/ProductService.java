package com.example.springsecurity.service.interfaces;

import com.example.springsecurity.exception.ProductNotFoundException;
import com.example.springsecurity.web.model.ProductDto;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 3:27 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface ProductService {

    Set<ProductDto> getAllProducts();
    ProductDto createProduct(ProductDto productDto);
    ProductDto getProductById(UUID productId) throws ProductNotFoundException;
}
