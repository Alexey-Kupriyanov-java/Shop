package com.example.shop.dto;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Objects;

@Data
@Embeddable
public class PositionDto {
    private long goodsId;
    private int quantity;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositionDto that = (PositionDto) o;
        return goodsId == that.goodsId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId);
    }
}
