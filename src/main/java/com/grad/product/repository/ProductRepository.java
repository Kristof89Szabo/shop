package com.grad.product.repository;

import com.grad.product.domain.Product;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);


    @Query("SELECT entity as e FROM products as p")
    List<Product> fetchOrders();
}
