package com.example.shop.controller;

import com.example.shop.dto.PositionDto;
import com.example.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("/add")
    public boolean addPosition(@RequestParam long goodsId, @RequestParam int quantity) {
        return cartService.addPosition(goodsId, quantity);
    }
}
