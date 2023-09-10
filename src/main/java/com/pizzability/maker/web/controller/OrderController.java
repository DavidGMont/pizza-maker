package com.pizzability.maker.web.controller;

import com.pizzability.maker.persistence.entity.OrderEntity;
import com.pizzability.maker.projection.OrderSummary;
import com.pizzability.maker.service.OrderService;
import com.pizzability.maker.service.dto.RandomOrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll() {
        return ResponseEntity.ok(this.orderService.getAll());
    }

    @GetMapping("/today")
    public ResponseEntity<List<OrderEntity>> getTodaysOrders() {
        return ResponseEntity.ok(this.orderService.getTodaysOrders());
    }

    @GetMapping("/external")
    public ResponseEntity<List<OrderEntity>> getExternalOrders() {
        return ResponseEntity.ok(this.orderService.getExternalOrders());
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<OrderEntity>> getCustomerOrders(@PathVariable String id) {
        return ResponseEntity.ok(this.orderService.getCustomerOrders(id));
    }

    @GetMapping("/summary/{id}")
    public ResponseEntity<OrderSummary> getSummary(@PathVariable int id) {
        return ResponseEntity.ok(this.orderService.getSummary(id));
    }

    @PostMapping("/random")
    public ResponseEntity<Boolean> randomOrder(@RequestBody RandomOrderDto dto) {
        return ResponseEntity.ok(this.orderService.saveRandomOrder(dto));
    }
}
