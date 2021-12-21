package com.example.shop.service.impl;

import com.example.shop.dto.CartDto;
import com.example.shop.dto.OrderDto;
import com.example.shop.entity.Order;
import com.example.shop.repository.OrderRepository;
import com.example.shop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class OrderServiceImpl implements OrderService {
    private final CartDto cartDto;
    private final OrderRepository orderRepository;
    private final ConversionService conversionService;

    @Override
    public OrderDto create(OrderDto orderDto) {
        orderDto.setPositions(cartDto.getPositionDtoList());
        orderDto.setTotal(orderDto.getPositions().stream()
                .mapToDouble(position -> position.getQuantity() * position.getPrice())
                .reduce(Double::sum).orElse(-1));
        Order order = conversionService.convert(orderDto, Order.class);
        orderRepository.save(order);
        return conversionService.convert(order, OrderDto.class);
    }

    @Override
    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(order -> conversionService.convert(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findByEmail(String email) {
        Order order = orderRepository.findByEmail(email);
        return conversionService.convert(order, OrderDto.class);
    }
}
