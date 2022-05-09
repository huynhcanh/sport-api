package com.ctlht.repository.custom;

import com.ctlht.entity.ProductEntity;

import java.util.List;
import java.util.Map;

public interface ProductRepositoryCustom {
    List<ProductEntity> getBuildingByFields(Map<String, String> params);
    List<ProductEntity> findTop3ByTop3LatestId();
}
