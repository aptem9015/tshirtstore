package com.example.tshirtstore.services;


import com.example.tshirtstore.entities.Order;
import com.example.tshirtstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public void setRepository(OrderRepository orderRepository) { this.orderRepository = orderRepository; }

    public void saveOrder(Order order){this.orderRepository.save(order);}

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
