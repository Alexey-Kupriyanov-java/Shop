package com.example.shop.controller;

import com.example.shop.dto.GoodsDto;
import com.example.shop.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goods")
public class GoodsController {
    private final GoodsService goodsService;

    @GetMapping("/{id}")
    public GoodsDto findById(@PathVariable("id") long id) {
        return goodsService.findById(id);
    }

    @GetMapping
    public List<GoodsDto> findAll() {
        return goodsService.findAll();
    }

    @PostMapping
    public GoodsDto create(@RequestBody GoodsDto goodsDto) {
        return goodsService.create(goodsDto);
    }

    @PutMapping
    public GoodsDto update(@RequestBody GoodsDto goodsDto) {
        return goodsService.update(goodsDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        goodsService.delete(id);
    }
}
