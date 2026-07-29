package com.example.final_proj_training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.final_proj_training.dtos.CategoryRequest;
import com.example.final_proj_training.dtos.CategoryResponse;
import com.example.final_proj_training.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request){

        return ResponseEntity.ok(
                categoryService.createCategory(request)
        );
    }




    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){

        return ResponseEntity.ok(
                categoryService.getAllCategories()
        );
    }





    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(
            @PathVariable int id){

        return ResponseEntity.ok(
                categoryService.getCategoryById(id)
        );
    }





    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable int id,
            @RequestBody CategoryRequest request){


        return ResponseEntity.ok(
                categoryService.updateCategory(id,request)
        );
    }





    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(
            @PathVariable int id){


        categoryService.deleteCategory(id);


        return ResponseEntity.noContent().build();
    }
}
