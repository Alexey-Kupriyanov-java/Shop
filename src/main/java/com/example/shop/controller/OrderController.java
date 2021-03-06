package com.example.shop.controller;

import com.example.shop.dto.OrderDto;
import com.example.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public OrderDto create(@RequestBody OrderDto orderDto) {
        return orderService.create(orderDto);
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/email/{email}")
    public OrderDto findByEmail(@PathVariable String email) {
        return orderService.findByEmail(email);
    }

}
