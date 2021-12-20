package com.example.shop.dto;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class PositionDto {
    private long goodsId;
    private int quantity;
    private double price;
}
