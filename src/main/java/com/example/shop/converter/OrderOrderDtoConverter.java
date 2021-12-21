package com.example.shop.converter;

import com.example.shop.dto.OrderDto;
import com.example.shop.entity.Order;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrderOrderDtoConverter implements Converter<Order, OrderDto> {

    @Override
    public OrderDto convert(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .email(order.getEmail())
                .phone(order.getPhone())
                .shippingAddress(order.getShippingAddress())
                .total(order.getTotal())
                .positions(order.getPositions())
                .build();
    }
}
