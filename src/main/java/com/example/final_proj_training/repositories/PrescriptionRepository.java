package com.example.final_proj_training.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.final_proj_training.models.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{

	
    // Get all prescriptions of a user
    @Query("SELECT p FROM Prescription p WHERE p.user_id = :user_id")
    List<Prescription> getAllPrescriptionsByUserId(
            @Param("user_id") int user_id);

    // Get prescription by id and user id
    @Query("SELECT p FROM Prescription p WHERE p.id = :prescription_id AND p.user_id = :user_id")
    Optional<Prescription> getPrescriptionById(
            @Param("prescription_id") int prescription_id,
            @Param("user_id") int user_id);
}
