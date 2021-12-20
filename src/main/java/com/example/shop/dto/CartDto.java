package com.example.shop.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
@Data
public class CartDto {
    private final List<PositionDto> positionDtoList = new ArrayList<>();
}
