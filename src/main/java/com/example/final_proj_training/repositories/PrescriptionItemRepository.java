package com.example.final_proj_training.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.final_proj_training.models.PrescriptionItem;

@Repository
public interface PrescriptionItemRepository extends JpaRepository<PrescriptionItem, Integer>{

	
    // Get all medicines of a prescription
    @Query("SELECT pi FROM PrescriptionItem pi WHERE pi.prescription_id = :prescription_id")
    List<PrescriptionItem> getPrescriptionItemsByPrescriptionId(
            @Param("prescription_id") int prescription_id);

    // Get all prescriptions containing a medicine
    @Query("SELECT pi FROM PrescriptionItem pi WHERE pi.medicine_id = :medicine_id")
    List<PrescriptionItem> getPrescriptionItemsByMedicineId(
            @Param("medicine_id") int medicine_id);
}
