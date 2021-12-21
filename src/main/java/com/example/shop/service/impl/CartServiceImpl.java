package com.example.shop.service.impl;

import com.example.shop.dto.CartDto;
import com.example.shop.dto.PositionDto;
import com.example.shop.repository.GoodsRepository;
import com.example.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CartServiceImpl implements CartService {
    private final CartDto cartDto;
    private final GoodsRepository goodsRepository;

    @Override
    public boolean addPosition(long goodsId, int quantity) {
        PositionDto positionDto = new PositionDto();
        positionDto.setGoodsId(goodsId);
        int index;
        if ((index = cartDto.getPositionDtoList().indexOf(positionDto)) != -1) {
            positionDto.setQuantity(quantity + cartDto.getPositionDtoList().get(index).getQuantity());
            positionDto.setPrice(goodsRepository.findById(goodsId).orElseThrow().getPrice());
            cartDto.getPositionDtoList().set(index, positionDto);
            return true;
        }
        positionDto.setQuantity(quantity);
        positionDto.setPrice(goodsRepository.findById(goodsId).orElseThrow().getPrice());
        return cartDto.getPositionDtoList().add(positionDto);
    }

    @Override
    public boolean removePosition(long goodsId) {
        PositionDto positionDto = new PositionDto();
        positionDto.setGoodsId(goodsId);
        return cartDto.getPositionDtoList().remove(positionDto);
    }

    @Override
    public List<PositionDto> getAllPositions() {
        return cartDto.getPositionDtoList();
    }
}
