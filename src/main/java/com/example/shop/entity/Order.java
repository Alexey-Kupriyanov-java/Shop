package com.example.shop.entity;

import com.example.shop.dto.PositionDto;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "total")
    private double total;

    @ElementCollection
    @CollectionTable(name = "order_positions", joinColumns = @JoinColumn(name = "order_id"))
    private List<PositionDto> positions;
}
