package com.example.shop.dto;

import lombok.*;

import java.util.Objects;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDto {
    private long id;
    private String name;
    private String description;
    private int quantity;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsDto goodsDto = (GoodsDto) o;
        return id == goodsDto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


