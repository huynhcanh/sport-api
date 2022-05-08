package com.ctlht.model.mapper;

import com.ctlht.entity.CategoryEntity;
import com.ctlht.model.reponse.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CategoryResponse toReponse(CategoryEntity entity) {
        CategoryResponse categoryResponse = modelMapper.map(entity, CategoryResponse.class);
        return categoryResponse;
    }
}
