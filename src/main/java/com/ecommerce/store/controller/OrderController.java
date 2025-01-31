package com.ecommerce.store.controller;

import com.ecommerce.store.dto.OrderRequestDTO;
import com.ecommerce.store.model.Order;
import com.ecommerce.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        List<String> productNames = orderRequestDTO.getProdutos().stream()
                .map(OrderRequestDTO.ProductDTO::getNome)
                .toList();
        Order order = orderService.createOrder(orderRequestDTO.getCpf(), productNames);
        return ResponseEntity.ok(order);
    }
}