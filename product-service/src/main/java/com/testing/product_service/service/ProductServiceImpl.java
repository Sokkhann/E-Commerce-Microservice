package com.testing.product_service.service;

import com.testing.product_service.dto.ProductDto;
import com.testing.product_service.model.Product;
import com.testing.product_service.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    // Convert DTO → Entity
    private Product mapToEntity(ProductDto dto) {
        return new Product(dto.getId(), dto.getName(), dto.getDescription(), dto.getPrice());
    }

    // Convert Entity → DTO
    private ProductDto mapToDto(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(String id) {
        Product product = productRepository.findById(id).orElseThrow();
        return mapToDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapToEntity(productDto);
        Product saved = productRepository.save(product);
        return mapToDto(saved);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
