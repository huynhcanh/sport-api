package com.ctlht.api;

import com.ctlht.model.response.CategoryResponse;
import com.ctlht.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryApi {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryResponse> getCategories() {
        List<CategoryResponse> categoryResponses = categoryService.findAll();
        return categoryResponses;
    }
}

