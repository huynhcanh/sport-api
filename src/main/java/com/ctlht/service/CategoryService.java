package com.ctlht.service;

import com.ctlht.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAll();
}
