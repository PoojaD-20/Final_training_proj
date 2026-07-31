package com.example.final_proj_training.serv_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_proj_training.dtos.CategoryRequest;
import com.example.final_proj_training.dtos.CategoryResponse;
import com.example.final_proj_training.exceptions.DuplicateResourceException;
import com.example.final_proj_training.exceptions.ResourceNotFoundException;
import com.example.final_proj_training.models.Category;
import com.example.final_proj_training.repositories.CategoryRepository;
import com.example.final_proj_training.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
//	@Override
//    public CategoryResponse createCategory(
//            CategoryRequest request) {
//
//
//        if(categoryRepository
//                .findByName(request.getName())
//                .isPresent()) {
//
//            throw new DuplicateResourceException(
//                    "Category already exists"
//            );
//        }
//
//
//        Category category = new Category();
//
//        category.setName(request.getName());
//
//
//        Category savedCategory =
//                categoryRepository.save(category);
//
//
//        return mapToResponse(savedCategory);
//    }



    @Override
    public List<CategoryResponse> getAllCategories() {

        return categoryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }



    @Override
    public CategoryResponse getCategoryById(int id) {


        Category category =
                categoryRepository.findById(id)
                .orElseThrow(
                    () -> new ResourceNotFoundException(
                        "Category not found"
                    )
                );


        return mapToResponse(category);
    }




//    @Override
//    public CategoryResponse updateCategory(
//            int id,
//            CategoryRequest request) {
//
//
//        Category category =
//                categoryRepository.findById(id)
//                .orElseThrow(
//                    () -> new ResourceNotFoundException(
//                        "Category not found"
//                    )
//                );
//
//
//        category.setName(request.getName());
//
//
//        Category updated =
//                categoryRepository.save(category);
//
//
//        return mapToResponse(updated);
//    }
//
//
//
//
//    @Override
//    public void deleteCategory(int id) {
//
//
//        Category category =
//                categoryRepository.findById(id)
//                .orElseThrow(
//                    () -> new ResourceNotFoundException(
//                        "Category not found"
//                    )
//                );
//
//
//        categoryRepository.delete(category);
//
//    }




    private CategoryResponse mapToResponse(
            Category category){

        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }

}
