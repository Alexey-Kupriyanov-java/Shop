package com.example.shop.converter;

import com.example.shop.dto.OrderDto;
import com.example.shop.entity.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoOrderConverter implements Converter<OrderDto, Order> {

    @Override
    public Order convert(OrderDto orderDto) {
        return Order.builder()
                .email(orderDto.getEmail())
                .phone(orderDto.getPhone())
                .shippingAddress(orderDto.getShippingAddress())
                .total(orderDto.getTotal())
                .positions(orderDto.getPositions())
                .build();
    }
}
