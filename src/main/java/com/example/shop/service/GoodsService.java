package com.example.shop.service;

import com.example.shop.dto.GoodsDto;

import java.util.List;

public interface GoodsService {
    GoodsDto findById(long id);

    List<GoodsDto> findAll();

    GoodsDto create(GoodsDto goodsDto);

    GoodsDto update(long id, GoodsDto goodsDto);

    void delete(long id);
}
