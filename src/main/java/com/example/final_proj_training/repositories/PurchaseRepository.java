package com.example.final_proj_training.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.final_proj_training.models.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer>{

}
