package com.example.final_proj_training.services;

import java.util.List;

import com.example.final_proj_training.dtos.CategoryRequest;
import com.example.final_proj_training.dtos.CategoryResponse;

public interface CategoryService {

//	CategoryResponse createCategory(CategoryRequest request);


    List<CategoryResponse> getAllCategories();


    CategoryResponse getCategoryById(int id);


//    CategoryResponse updateCategory(
//            int id,
//            CategoryRequest request
//    );
//
//
//    void deleteCategory(int id);
}
