package com.grad.product.service;

import com.grad.product.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    Optional<ProductDto> fetchProduct(String id);

    List<ProductDto> fetchOrders();
}
