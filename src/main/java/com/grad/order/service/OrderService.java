package com.grad.order.service;

import com.grad.order.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<OrderDto> getOrder(Long id);

    List<OrderDto> getOrders();

    OrderDto addOrder(OrderDto orderDto);
}
