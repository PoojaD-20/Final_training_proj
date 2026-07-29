package com.example.final_proj_training.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.final_proj_training.models.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    @Query("SELECT p FROM Purchase p WHERE p.user_id = :userId")
    List<Purchase> getAllPurchasesByUserId(@Param("userId") int userId);

    @Query("SELECT p FROM Purchase p WHERE p.id = :purchaseId AND p.user_id = :userId")
    Optional<Purchase> getPurchaseById(@Param("purchaseId") int purchaseId,
                                       @Param("userId") int userId);

    @Query("SELECT p FROM Purchase p WHERE p.medicine_id = :medicineId AND p.user_id = :userId")
    List<Purchase> getPurchasesByMedicineId(@Param("medicineId") int medicineId,
                                            @Param("userId") int userId);

}
