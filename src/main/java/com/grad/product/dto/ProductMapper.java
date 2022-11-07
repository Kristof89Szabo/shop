package com.grad.product.dto;

import com.grad.product.domain.Product;
import jakarta.inject.Singleton;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Singleton
@Mapper(componentModel =  "jsr330")
public interface ProductMapper {

    @Mapping(target = "id", source = "productDto.id")
    @Mapping(target = "name", source = "productDto.name")
    @Mapping(target = "weight", source = "productDto.weight")
    Product toProduct(ProductDto productDto);


    ProductDto toProductDto(Product product);

}
