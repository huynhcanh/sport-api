package com.ctlht.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private Integer quantity;
    private Float totalMoney;
    private ProductSizeResponse productsize;
}
