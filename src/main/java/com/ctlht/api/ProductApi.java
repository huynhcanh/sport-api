package com.ctlht.api;

import com.ctlht.constant.web.KeyParamsUrlConstant;
import com.ctlht.model.reponse.ProductResponse;
import com.ctlht.model.reponse.ProductSizeResponse;
import com.ctlht.model.request.ProductRequest;
import com.ctlht.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProductApi {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductResponse> productsByParams(@RequestParam(required = false) Map<String, String> params) {
        List<ProductResponse> productResponseList = productService.findProductsByParams(params);
        return productResponseList;
    }

    @GetMapping("/top3-products")
    public List<ProductResponse> getTop3Products() {
        List<ProductResponse> productResponseList = productService.findTop3ByTop3LatestId();
        return productResponseList;
    }

    @GetMapping("/product")
    public ProductResponse getProduct(@RequestParam(name = KeyParamsUrlConstant.ID_PRODUCT) Long id) {
        ProductResponse productResponse = productService.findById(id);
        return productResponse;
    }

    @PostMapping("/product")
    public ProductSizeResponse insertProduct(@RequestBody ProductRequest productRequest) {
        return productService.insertOrUpdate(productRequest);
    }

    @PutMapping("/product")
    public ProductSizeResponse updateProduct(@RequestBody ProductRequest productRequest) {
        return productService.insertOrUpdate(productRequest);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        System.out.println("xóa "+ id);
    }
}