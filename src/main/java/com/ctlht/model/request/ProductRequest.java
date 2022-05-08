package com.ctlht.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private Long idProductSize;
    private String name;
    private Float unitPrice;
    private Float discount;
    private String description;
    private String categoryCode;
    private String sizeCode;
    private Integer quantity;
    private List<String> images;
}
