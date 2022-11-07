package com.grad.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Introspected
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderDto {

    @JsonProperty("orderId")
    private Long id;

    @JsonProperty("orderedBy")
    private String orderedBy;



}
