package com.example.springsecurity.web.mapper.interfaces;

import com.example.springsecurity.domain.entity.Product;
import com.example.springsecurity.web.model.ProductDto;

import java.util.Set;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:19 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface ProductMapper {

    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto productDto);

    Set<ProductDto> productsToProductDtos(Set<Product> products);
    Set<Product> productDtosToProduct(Set<ProductDto> productDtos);
}
