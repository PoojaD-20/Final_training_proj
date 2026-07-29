package com.example.final_proj_training.services;

import java.util.List;

import com.example.final_proj_training.dtos.PurchaseRequest;
import com.example.final_proj_training.dtos.PurchaseResponse;

public interface PurchaseService {
   // Add a new purchase
    PurchaseResponse addPurchase(PurchaseRequest request, int user_id);

    // Get all purchases of the logged-in user
    List<PurchaseResponse> getAllPurchases(int user_id);

    // Get a purchase by its id
    PurchaseResponse getPurchaseById(int purchaseId, int user_id);

    // Get purchase history of a particular medicine
    List<PurchaseResponse> getPurchasesByMedicineId(int medicineId, int user_id);
}
