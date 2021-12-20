package com.example.shop.service.impl;

import com.example.shop.dto.CartDto;
import com.example.shop.dto.OrderDto;
import com.example.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final CartDto cartDto;

    @Autowired
    public OrderServiceImpl(CartDto cartDto) {
        this.cartDto = cartDto;
    }

    @Override
    public OrderDto create(OrderDto orderDto) {
        orderDto.setPositions(cartDto.getPositionDtoList());
        return orderDto;
    }
}
