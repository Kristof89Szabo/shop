package com.grad.order.repository;

import com.grad.order.domain.Order;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Orders as o")
    List<Order> getAllOrders();
}
