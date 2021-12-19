package com.example.shop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "email")
    //@Email(message = "*Please provide a valid Email")
    //@NotEmpty(message = "*Please provide your email")
    private String email;

    @Column(name = "phone")
    //@NotEmpty(message = "*Please provide your phone")
    private String phone;

    @Column(name = "cart_id")
    private Long cart_id;

    @Column(name = "shipping_address")
    private String shipping_address;

    @ElementCollection
    @CollectionTable(name = "order_positions", joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderPosition> orderPositions;
}
