package com.grad.product.service;

import com.grad.product.domain.Product;
import com.grad.product.dto.ProductDto;
import com.grad.product.dto.ProductMapper;
import com.grad.product.repository.ProductRepository;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Optional<Product> productOptional = productRepository.findByName(productDto.getName().trim());
        if (productOptional.isEmpty()) {
            Product product = mapper.toProduct(productDto);
            Product savedProduct = productRepository.save(product);
            return mapper.toProductDto(savedProduct);
        }
        return mapper.toProductDto(productOptional.get());
    }

    @Override
    public Optional<ProductDto> fetchProduct(String id) {
        Optional<Product> productById = productRepository.findById(Long.valueOf(id));
        return productById.map(mapper::toProductDto);
    }

    @Override
    public List<ProductDto> fetchProducts() {
        return productRepository.fetchProducts().stream()
                .map(mapper::toProductDto)
                .collect(Collectors.toList());
    }
}
