package com.example.shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "cart_id")
    private Long cart_id;

    @Column(name = "shipping_address")
    private String shipping_address;


}
