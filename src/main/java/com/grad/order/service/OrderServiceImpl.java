package com.grad.order.service;

import com.grad.order.domain.Order;
import com.grad.order.dto.OrderDto;
import com.grad.order.dto.OrderMapper;
import com.grad.order.repository.OrderRepository;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Singleton
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    @Override
    public Optional<OrderDto> getOrder(Long id) {
        Optional<Order> orderById = orderRepository.findById(id);
        return orderById.map(mapper::toOrderDto);
    }

    @Override
    public List<OrderDto> getOrders() {
        List<OrderDto> orders = new ArrayList<>();
        return orderRepository.getAllOrders()
                .stream()
                .map(mapper::toOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto addOrder(OrderDto orderDTO) {
        Order order = mapper.toOrder(orderDTO);
        order.setId(null);
        Order saved = orderRepository.save(order);
        return mapper.toOrderDto(saved);
    }
}
