package com.grad.order.dto;

import com.grad.order.domain.Order;
import jakarta.inject.Singleton;
import org.mapstruct.Mapper;

@Singleton
@Mapper(componentModel = "jsr330")
public interface OrderMapper {
    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);
}
