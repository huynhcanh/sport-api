package com.ctlht.service;

import com.ctlht.model.reponse.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> findAll();
}
