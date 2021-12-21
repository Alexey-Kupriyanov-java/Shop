package com.example.shop.service;

import com.example.shop.dto.PositionDto;

import java.util.List;

public interface CartService {
    boolean addPosition(long goodsId, int quantity);

    boolean removePosition(long goodsId);

    List<PositionDto> getAllPositions();
}
