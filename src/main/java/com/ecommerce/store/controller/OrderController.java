package com.ecommerce.store.controller;

import com.ecommerce.store.model.Order;
import com.ecommerce.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest orderRequest) {
        Order order = orderService.createOrder(orderRequest.getCpf(), orderRequest.getProductNames());
        return ResponseEntity.ok(order);
    }
}

