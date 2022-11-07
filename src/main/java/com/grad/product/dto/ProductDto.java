package com.grad.product.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("productName")
    private String name;

    @JsonProperty("productWeight")
    private Double weight;
}
