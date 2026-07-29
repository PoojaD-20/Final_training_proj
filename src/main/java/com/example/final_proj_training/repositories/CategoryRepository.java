package com.example.final_proj_training.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.final_proj_training.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Optional<Category> findByName(String name);
}
