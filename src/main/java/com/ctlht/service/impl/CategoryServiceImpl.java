package com.ctlht.service.impl;

import com.ctlht.entity.CategoryEntity;
import com.ctlht.model.mapper.CategoryMapper;
import com.ctlht.model.response.CategoryResponse;
import com.ctlht.repository.CategoryRepository;
import com.ctlht.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponse> findAll() {

        List<CategoryResponse> blogResponses = new ArrayList<>();

        List<CategoryEntity> categoryEntities = categoryRepository.findAll();
        for(CategoryEntity categoryEntity : categoryEntities){
            blogResponses.add(categoryMapper.toReponse(categoryEntity));
        }
        return blogResponses;
    }
}
