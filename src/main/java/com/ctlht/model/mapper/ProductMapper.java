package com.ctlht.model.mapper;

import com.ctlht.entity.ProductEntity;
import com.ctlht.model.response.ProductResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProductResponse toReponse(ProductEntity entity) {
            ProductResponse productResponse = modelMapper.map(entity, ProductResponse.class);
            return productResponse;
    }
}
