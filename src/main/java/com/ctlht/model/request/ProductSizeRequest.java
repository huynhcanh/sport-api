package com.ctlht.model.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSizeRequest {
    private Long id;
    private String name;
    private Float unitPrice;
    private Float discount;
    private String description;
    private String sizeCode;
    private Integer quantity;
    private String categoryCode;
    private MultipartFile[] images;
}