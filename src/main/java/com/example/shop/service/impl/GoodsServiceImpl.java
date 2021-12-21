package com.example.shop.service.impl;

import com.example.shop.dto.GoodsDto;
import com.example.shop.entity.Goods;
import com.example.shop.repository.GoodsRepository;
import com.example.shop.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final ConversionService conversionService;

    @Override
    public GoodsDto findById(long id) {
        Goods result = goodsRepository.findById(id).orElseThrow();
        return conversionService.convert(result, GoodsDto.class);
    }

    @Override
    public List<GoodsDto> findAll() {
        return goodsRepository.findAll().stream()
                .map(goods -> conversionService.convert(goods, GoodsDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GoodsDto create(GoodsDto goodsDto) {
        Goods goods = conversionService.convert(goodsDto, Goods.class);
        Goods result = goodsRepository.save(goods);
        return conversionService.convert(result, GoodsDto.class);
    }

    @Override
    public GoodsDto update(GoodsDto goodsDto) {
        Goods goods = conversionService.convert(goodsDto, Goods.class);
        Goods result = goodsRepository.save(goods);
        return conversionService.convert(result, GoodsDto.class);
    }

    @Override
    public void delete(long id) {
        goodsRepository.deleteById(id);
    }
}
