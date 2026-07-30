package com.example.final_proj_training.serv_impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.final_proj_training.dtos.PurchaseRequest;
import com.example.final_proj_training.dtos.PurchaseResponse;
import com.example.final_proj_training.exceptions.ResourceNotFoundException;
import com.example.final_proj_training.models.Medicine;
import com.example.final_proj_training.models.Purchase;
import com.example.final_proj_training.repositories.CategoryRepository;
import com.example.final_proj_training.repositories.MedicineRepository;
import com.example.final_proj_training.repositories.PurchaseRepository;
import com.example.final_proj_training.services.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
@Transactional
public PurchaseResponse addPurchase(PurchaseRequest request, int user_id) {

    // Check whether category exists
    categoryRepository.findById(request.getCategoryId())
            .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

    // Check expiry date
    if (request.getExpiryDate().isBefore(LocalDate.now())) {
        throw new IllegalArgumentException("Medicine expiry date cannot be in the past");
    }

    // Check whether medicine already exists
    Optional<Medicine> optionalMedicine =
            medicineRepository.findByNameAndCategoryIdAndUserId(
                    request.getName(),
                    request.getCategoryId(),
                    user_id);

    Medicine medicine;

    if (optionalMedicine.isPresent()) {

        // Existing Medicine
        medicine = optionalMedicine.get();

        medicine.setQuantity(
                medicine.getQuantity() + request.getQuantity());

        // Update latest price
        medicine.setPrice(request.getPrice());

        // Update latest expiry date
        medicine.setExpiryDate(request.getExpiryDate());

    } else {

        // Create New Medicine
        medicine = new Medicine();

        medicine.setName(request.getName());
        medicine.setCategory_id(request.getCategoryId());
        medicine.setPrice(request.getPrice());
        medicine.setQuantity(request.getQuantity());
        medicine.setExpiryDate(request.getExpiryDate());
        medicine.setUser_id(user_id);
        medicine.setDeleted(false);

    }

    // Update medicine status
    medicine.updateStatus();

    // Save medicine
    Medicine savedMedicine = medicineRepository.save(medicine);

    // Create purchase record
    Purchase purchase = new Purchase();

    purchase.setMedicine_id(savedMedicine.getId());
    purchase.setUser_id(user_id);
    purchase.setQuantity(request.getQuantity());
    purchase.setPrice(request.getPrice());
    purchase.setPurchaseDate(LocalDate.now());

    // Save purchase
    Purchase savedPurchase = purchaseRepository.save(purchase);

    return mapToResponse(savedPurchase, savedMedicine.getName());

}

@Override
public List<PurchaseResponse> getAllPurchases(int user_id) {

    List<Purchase> purchases = purchaseRepository.getAllPurchasesByUserId(user_id);

    List<PurchaseResponse> purchaseResponses = new ArrayList<>();

    for (Purchase purchase : purchases) {

        Medicine medicine = medicineRepository
                .findByIdAndUserId(purchase.getMedicine_id(), user_id)
                .orElseThrow(() -> new ResourceNotFoundException("Medicine not found"));

        PurchaseResponse response = mapToResponse(purchase, medicine.getName());

        purchaseResponses.add(response);
    }

    return purchaseResponses;
}

@Override
public PurchaseResponse getPurchaseById(int purchaseId, int user_id) {

    Purchase purchase = purchaseRepository
            .getPurchaseById(purchaseId, user_id)
            .orElseThrow(() -> new ResourceNotFoundException("Purchase not found"));

    Medicine medicine = medicineRepository
            .findByIdAndUserId(purchase.getMedicine_id(), user_id)
            .orElseThrow(() -> new ResourceNotFoundException("Medicine not found"));

    return mapToResponse(purchase, medicine.getName());

}

@Override
public List<PurchaseResponse> getPurchasesByMedicineId(int medicineId, int user_id) {

    Medicine medicine = medicineRepository
            .findByIdAndUserId(medicineId, user_id)
            .orElseThrow(() -> new ResourceNotFoundException("Medicine not found"));

    List<Purchase> purchases =
            purchaseRepository.getPurchasesByMedicineId(medicineId, user_id);

    List<PurchaseResponse> purchaseResponses = new ArrayList<>();

    for (Purchase purchase : purchases) {

        purchaseResponses.add(mapToResponse(purchase, medicine.getName()));

    }

    return purchaseResponses;

}

private PurchaseResponse mapToResponse(Purchase purchase, String medicineName) {

    PurchaseResponse response = new PurchaseResponse();

    response.setId(purchase.getId());
    response.setMedicineName(medicineName);
    response.setQuantity(purchase.getQuantity());
    response.setPrice(purchase.getPrice());
    response.setPurchaseDate(purchase.getPurchaseDate());

    return response;

}





}    
