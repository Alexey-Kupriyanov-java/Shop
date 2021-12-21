package com.example.shop.controller;

import com.example.shop.dto.PositionDto;
import com.example.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public List<PositionDto> getAllPositions() {
        return cartService.getAllPositions();
    }

    @PostMapping
    public boolean addPosition(@RequestParam long goodsId, @RequestParam int quantity) {
        return cartService.addPosition(goodsId, quantity);
    }

    @DeleteMapping
    public boolean removePosition(@RequestParam long goodsId) {
        return cartService.removePosition(goodsId);
    }
}
