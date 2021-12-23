package com.example.shop.controller;

import com.example.shop.dto.GoodsDto;
import com.example.shop.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsService goodsService;

    @GetMapping("/{id}")
    public GoodsDto findById(@PathVariable("id") Long id) {
        return goodsService.findById(id);
    }

    @GetMapping
    public List<GoodsDto> findAll() {
        return goodsService.findAll();
    }

    @PostMapping
    public GoodsDto create(@RequestBody GoodsDto goodsDto) {
        return goodsService.save(goodsDto);
    }

    @PutMapping
    public GoodsDto update(@RequestBody GoodsDto goodsDto) {
        return goodsService.update(goodsDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        goodsService.delete(id);
    }
}
