package com.example.shop.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cart_id;

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Integer price;
}
