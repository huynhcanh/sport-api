package com.ctlht.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSizeResponse {
    private Long id;
    private Integer quantity;
    private SizeResponse size;
    private ProductResponse product;
}
