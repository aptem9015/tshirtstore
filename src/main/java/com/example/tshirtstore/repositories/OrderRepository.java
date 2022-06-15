package com.example.tshirtstore.repositories;

import com.example.tshirtstore.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
