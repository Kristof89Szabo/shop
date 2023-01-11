package com.grad.product.controller;

import com.grad.product.dto.ProductDto;
import com.grad.product.service.ProductService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

import static com.grad.product.controller.ProductController.BASE_URL;

@Controller(BASE_URL)
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    static final String BASE_URL = "/product";

    private final ProductService productService;

    @Post("/create-product")
    public HttpResponse<ProductDto> createNewProduct(@Body @NotNull ProductDto productDto) {
        log.info("Valami");
        ProductDto savedProduct = productService.createProduct(productDto);
        return HttpResponse.ok(savedProduct);
    }

    @Get("/{id}")
    public HttpResponse<ProductDto> fetchProductById(@PathVariable String id) {
        Optional<ProductDto> productDtoOptional = productService.fetchProduct(id);
        if (productDtoOptional.isPresent()) {
            return HttpResponse.ok(productDtoOptional.get());
        }
        return  HttpResponse.notFound();
    }

    @Get
    public HttpResponse<List<ProductDto>> fetchAllProducts(){
        return HttpResponse.ok(productService.fetchProducts());
    }

}
