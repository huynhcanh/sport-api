package com.ctlht.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private Long id;
    private Integer quantity;
    private Float totalMoney;
    private ProductSizeResponse productsize;
    private UserResponse user;
}
