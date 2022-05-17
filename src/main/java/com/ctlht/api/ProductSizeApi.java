package com.ctlht.api;

import com.ctlht.model.request.ProductSizeRequest;
import com.ctlht.model.response.ProductSizeResponse;
import com.ctlht.service.ProductSizeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductSizeApi {

    @Autowired
    ProductSizeService productSizeService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/productsizes")
    public List<ProductSizeResponse> usersByParams(@RequestParam(required = false) Map<String, String> params) {
        return productSizeService.productsizesByParams(params);
    }

    @GetMapping("/productsize/count")
    public long count() {
        return productSizeService.count();
    }

    @PostMapping("/productsize")
    public ProductSizeResponse insertProductSize(@RequestParam("productSizeRequest") String productSizeRequestJsonString,
                                                 @RequestParam("images") MultipartFile[] images) {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductSizeRequest productSizeRequest =null;
        try{
            productSizeRequest = objectMapper.readValue(productSizeRequestJsonString, ProductSizeRequest.class);
            productSizeRequest.setImages(images);
        }
        catch (Exception e){ e.printStackTrace(); }
        return productSizeService.insertOrUpdate(productSizeRequest);
    }

    @PutMapping("/productsize")
    public ProductSizeResponse updateProductSize(@RequestBody ProductSizeRequest productSizeRequest) {
        return productSizeService.insertOrUpdate(productSizeRequest);
    }

    @DeleteMapping("/productsizes")
    public void deleteNew(@RequestBody long[] ids) {
        productSizeService.deleteProductSizes(ids);
    }
}
