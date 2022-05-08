package com.ctlht.service;

import com.ctlht.model.reponse.ProductResponse;
import com.ctlht.model.reponse.ProductSizeResponse;
import com.ctlht.model.request.ProductRequest;

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
