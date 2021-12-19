package com.example.shop.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class OrderPosition {
    private Long product_id;
    private Integer quantity;
    private Integer price;
}
