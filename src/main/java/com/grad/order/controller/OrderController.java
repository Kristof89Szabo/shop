package com.grad.order.controller;

import com.grad.order.dto.OrderDto;
import com.grad.order.service.OrderService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import static com.grad.order.controller.OrderController.BASE_URL;


@Controller(BASE_URL)
@RequiredArgsConstructor
public class OrderController {

    static final String BASE_URL = "/order";


    private final OrderService orderService;

    @Get("/{id}")
    public HttpResponse<OrderDto> getOrder(@PathVariable("id") Long id) {

        Optional<OrderDto> mayBeOrder = orderService.getOrder(id);
        if (mayBeOrder.isPresent()) {
            return HttpResponse.ok(mayBeOrder.get());
        }
        return HttpResponse.notFound();
    }

    @Get
    public HttpResponse<List<OrderDto>> getAllOrders() {
        return HttpResponse.ok(this.orderService.getOrders());
    }

    @Post
    public HttpResponse<OrderDto> addOrder(@Body OrderDto orderDTO) {
        OrderDto savedOrder = orderService.addOrder(orderDTO);
        return HttpResponse.ok(savedOrder);
    }



}
