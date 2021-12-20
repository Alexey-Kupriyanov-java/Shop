package com.example.shop.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private long id;
    private String email;
    private String phone;
    private String shippingAddress;
    private List<PositionDto> positions;

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", positions=" + positions +
                '}';
    }
}
