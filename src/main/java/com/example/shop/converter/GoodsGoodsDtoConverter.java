package com.example.shop.converter;

import com.example.shop.dto.GoodsDto;
import com.example.shop.entity.Goods;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GoodsGoodsDtoConverter implements Converter<Goods, GoodsDto> {
    @Override
    public GoodsDto convert(Goods goods) {
        return GoodsDto.builder()
                .id(goods.getId())
                .name(goods.getName())
                .description(goods.getDescription())
                .quantity(goods.getQuantity())
                .price(goods.getPrice())
                .build();
    }
}
