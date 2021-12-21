package com.example.shop.service;

import com.example.shop.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto create(OrderDto orderDto);

    List<OrderDto> findAll();

    OrderDto findByEmail(String email);
}
