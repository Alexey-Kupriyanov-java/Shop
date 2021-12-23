package com.example.shop.service.impl;

import com.example.shop.dto.GoodsDto;
import com.example.shop.entity.Goods;
import com.example.shop.exception.InvalidRequestException;
import com.example.shop.exception.NotFoundException;
import com.example.shop.repository.GoodsRepository;
import com.example.shop.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;
    private final ConversionService conversionService;

    @Override
    public GoodsDto findById(Long id) {
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
    public GoodsDto save(GoodsDto goodsDto) {
        Goods goods = conversionService.convert(goodsDto, Goods.class);
        Goods result = goodsRepository.save(goods);
        return conversionService.convert(result, GoodsDto.class);
    }

    @Override
    public GoodsDto update(GoodsDto goodsDto) {
        if (goodsDto == null || goodsDto.getId() == null) {
            throw new InvalidRequestException("goodsDto or ID must not be null!");
        }
        Optional<Goods> optionalGoods = goodsRepository.findById(goodsDto.getId());
        if (optionalGoods.isEmpty()) {
            throw new NotFoundException("Goods with ID " + goodsDto.getId() + " does not exist.");
        }

        GoodsDto existingGoodsDto = conversionService.convert(optionalGoods.get(), GoodsDto.class);

        existingGoodsDto.setName(goodsDto.getName());
        existingGoodsDto.setDescription(goodsDto.getDescription());
        existingGoodsDto.setQuantity(goodsDto.getQuantity());
        existingGoodsDto.setPrice(goodsDto.getPrice());

        return save(existingGoodsDto);
    }

    @Override
    public void delete(Long id) {
        if (goodsRepository.findById(id).isEmpty()) {
            throw new NotFoundException("Goods with ID " + id + " does not exist.");
        }
        goodsRepository.deleteById(id);
    }
}
