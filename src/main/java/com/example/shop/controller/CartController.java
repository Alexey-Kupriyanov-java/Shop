package com.example.shop.controller;

import com.example.shop.dto.PositionDto;
import com.example.shop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("/add")
    public boolean addPosition(@RequestBody PositionDto positionDto) {
        return cartService.addPosition(positionDto);
    }
}
