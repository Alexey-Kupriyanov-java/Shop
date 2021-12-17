package com.example.shop.model;

import lombok.*;

import javax.persistence.*;
//import javax.validation.constraints.Min;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity", nullable = false)
    //@Min(value = 0, message = "*Quantity has to be non-negative number")
    private Integer quantity;

    @Column(name = "price", nullable = false)
    //@Min(value = 0, message = "*Price has to be non-negative number")
    private Integer price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
