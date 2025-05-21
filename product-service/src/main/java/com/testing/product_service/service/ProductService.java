package com.testing.product_service.service;

import com.testing.product_service.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    ProductDto getProductById(String id);
    ProductDto createProduct(ProductDto productDto);
    void deleteProduct(String id);
}
