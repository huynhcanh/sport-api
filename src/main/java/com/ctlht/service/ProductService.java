package com.ctlht.service;

import com.ctlht.model.request.ProductRequest;
import com.ctlht.model.response.ProductResponse;
import com.ctlht.model.response.ProductSizeResponse;

import java.util.List;
import java.util.Map;

public interface ProductService {

    // cutomer
    List<ProductResponse> findProductsByParams(Map<String, String> params);

    ProductResponse findById(Long id);

    List<ProductResponse> findTop3ByTop3LatestId();

    // admin
    ProductSizeResponse insertOrUpdate(ProductRequest productRequest);

    void deleteById(Long id);
}
