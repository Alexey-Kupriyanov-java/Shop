package com.example.shop.service;

import com.example.shop.dto.GoodsDto;

import java.util.List;

public interface GoodsService {
    GoodsDto findById(Long id);

    List<GoodsDto> findAll();

    GoodsDto save(GoodsDto goodsDto);

    GoodsDto update(GoodsDto goodsDto);

    void delete(Long id);
}
