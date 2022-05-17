package com.ctlht.service;

import com.ctlht.model.request.ProductSizeRequest;
import com.ctlht.model.response.ProductSizeResponse;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface  ProductSizeService {
    List<ProductSizeResponse> productsizesByParams(@RequestParam(required = false) Map<String, String> params);
    long getTotalItem();
    void deleteProductSizes(long[] ids);
    ProductSizeResponse insertOrUpdate(ProductSizeRequest productSizeRequest);
}
