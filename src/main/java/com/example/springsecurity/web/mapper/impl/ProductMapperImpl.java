package com.example.springsecurity.web.mapper.impl;

import com.example.springsecurity.domain.entity.Product;
import com.example.springsecurity.web.mapper.interfaces.ProductMapper;
import com.example.springsecurity.web.model.ProductDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 21, December 2021
 * Time: 2:22 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.web.mapper.impl
 * To change this template use File | Settings | File and Code Template
 */
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto productToProductDto(Product product) {
        if(product == null){
            return null;
        }
        ProductDto productDto = ProductDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .productType(product.getProductType())
                .build();
        return productDto;
    }

    @Override
    public Product productDtoToProduct(ProductDto productDto) {
        if(productDto == null){
            return null;
        }
        Product product = Product.builder()
                .productId(productDto.getProductId())
                .productName(productDto.getProductName())
                .productType(productDto.getProductType())
                .build();
        return product;
    }

    @Override
    public Set<ProductDto> productsToProductDtos(Set<Product> products) {
        return products.stream().map(this :: productToProductDto).collect(Collectors.toSet());
    }

    @Override
    public Set<Product> productDtosToProduct(Set<ProductDto> productDtos) {
        return productDtos.stream().map(this::productDtoToProduct).collect(Collectors.toSet());
    }
}
