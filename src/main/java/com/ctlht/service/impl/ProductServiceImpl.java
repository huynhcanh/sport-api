package com.ctlht.service.impl;

import com.ctlht.entity.ProductEntity;
import com.ctlht.entity.ProductSizeEntity;
import com.ctlht.model.mapper.ProductMapper;
import com.ctlht.model.mapper.ProductSizeMapper;
import com.ctlht.model.reponse.ProductResponse;
import com.ctlht.model.reponse.ProductSizeResponse;
import com.ctlht.model.request.ProductRequest;
import com.ctlht.repository.ProductReponsitory;
import com.ctlht.repository.ProductSizeReponsitory;
import com.ctlht.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductReponsitory productReponsitory;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductSizeMapper productSizeMapper;

    @Autowired
    ProductSizeReponsitory productSizeReponsitory;

    @Override
    public List<ProductResponse> findProductsByParams(Map<String, String> params) {
        List<ProductResponse> productResponse = new ArrayList<>();

        List<ProductEntity> productEntities = productReponsitory.getBuildingByFields(params);

        for(ProductEntity productEntity : productEntities){
            productResponse.add(productMapper.toReponse(productEntity));
        }
        return productResponse;
    }

    @Override
    public ProductResponse findById(Long id) {
        return productMapper.toReponse(productReponsitory.findById(id).get());
    }

    @Override
    public List<ProductResponse> findTop3ByTop3LatestId() {
        List<ProductResponse> productResponse = new ArrayList<>();

        List<ProductEntity> productEntities = productReponsitory.findTop3ByTop3LatestId();

        for(ProductEntity productEntity : productEntities){
            productResponse.add(productMapper.toReponse(productEntity));
        }
        return productResponse;
    }

    @Override
    public ProductSizeResponse insertOrUpdate(ProductRequest productRequest) {
        ProductSizeEntity productSizeEntity = productSizeMapper.toEntity(productRequest);
        if(productRequest.getIdProductSize() == null){ // insert
            ProductEntity productEntity = productSizeEntity.getProduct();
            productEntity=productReponsitory.save(productEntity);
            productSizeEntity.setProduct(productEntity);
        }
        productSizeEntity=productSizeReponsitory.save(productSizeEntity);
        return productSizeMapper.toResponse(productSizeEntity);
    }

    @Override
    public void deleteById(Long id) {
        productReponsitory.deleteById(id);
    }
}
