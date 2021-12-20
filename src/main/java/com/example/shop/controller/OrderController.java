package com.example.shop.controller;

import com.example.shop.dto.OrderDto;
import com.example.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public OrderDto create(@RequestBody OrderDto orderDto) {
        return orderService.create(orderDto);
    }
}
