package com.example.shop.service.impl;

import com.example.shop.dto.CartDto;
import com.example.shop.dto.PositionDto;
import com.example.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CartServiceImpl implements CartService {
    private final CartDto cartDto;

    @Autowired
    public CartServiceImpl(CartDto cartDto) {
        this.cartDto = cartDto;
    }

    @Override
    public boolean addPosition(PositionDto positionDto) {
        //TODO
        return cartDto.getPositionDtoList().add(positionDto);
    }
}
