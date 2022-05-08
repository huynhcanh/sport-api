package com.ctlht.model.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long id;
    private String name;
    private List<ImageResponse> images;
    private Float discount;
    private Float unitPrice;
    private CategoryResponse category;
    private String description;

}
