package com.example.shop.service;

import com.example.shop.dto.PositionDto;

public interface CartService {
    boolean addPosition(long goodsId, int quantity);
}
