package com.example.shop.converter;

import com.example.shop.dto.GoodsDto;
import com.example.shop.entity.Goods;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GoodsDtoGoodsConverter implements Converter<GoodsDto, Goods> {
    @Override
    public Goods convert(GoodsDto goodsDto) {
        return Goods.builder()
                .name(goodsDto.getName())
                .description(goodsDto.getDescription())
                .quantity(goodsDto.getQuantity())
                .price(goodsDto.getPrice())
                .build();
    }
}
