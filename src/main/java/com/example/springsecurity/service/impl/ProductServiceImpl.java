package com.example.springsecurity.service.impl;

import com.example.springsecurity.domain.entity.Product;
import com.example.springsecurity.domain.repository.ProductRepository;
import com.example.springsecurity.exception.ProductNotFoundException;
import com.example.springsecurity.service.interfaces.ProductService;
import com.example.springsecurity.web.mapper.interfaces.ProductMapper;
import com.example.springsecurity.web.model.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 22, December 2021
 * Time: 3:30 PM
 * Project: spring-security
 * Package Name: com.example.springsecurity.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public Set<ProductDto> getAllProducts() {
        Set<Product> products = productRepository.findAll().stream().collect(Collectors.toSet());
        return productMapper.productsToProductDtos(products);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        product = productRepository.save(product);
        return productMapper.productToProductDto(product);
    }

    @Override
    public ProductDto getProductById(UUID productId) throws ProductNotFoundException {
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product with product id "+ productId + " not found"));
        return productMapper.productToProductDto(product);
    }
}
