package com.example.shop.service.impl;

import com.example.shop.dto.GoodsDto;
import com.example.shop.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Override
    public GoodsDto findById(long id) {
        //TODO
        return GoodsDto.builder().id(id).build();
    }

    @Override
    public List<GoodsDto> findAll() {
        //TODO
        return List.of(GoodsDto.builder().id(1).build(), GoodsDto.builder().id(2).build());
    }

    @Override
    public GoodsDto create(GoodsDto goodsDto) {
        //TODO
        return goodsDto;
    }

    @Override
    public GoodsDto update(long id, GoodsDto goodsDto) {
        //TODO
        return goodsDto;
    }

    @Override
    public void delete(long id) {
        //TODO
    }
}
