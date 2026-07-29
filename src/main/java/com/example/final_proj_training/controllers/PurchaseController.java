package com.example.final_proj_training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.final_proj_training.dtos.PurchaseRequest;
import com.example.final_proj_training.dtos.PurchaseResponse;
import com.example.final_proj_training.services.PurchaseService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // Add Purchase
    @PostMapping
    public ResponseEntity<PurchaseResponse> addPurchase(
            @RequestBody PurchaseRequest request,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                purchaseService.addPurchase(request, user_id)
        );
    }

    // Get All Purchases
    @GetMapping
    public ResponseEntity<List<PurchaseResponse>> getAllPurchases(
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                purchaseService.getAllPurchases(user_id)
        );
    }

    // Get Purchase By Id
    @GetMapping("/{purchaseId}")
    public ResponseEntity<PurchaseResponse> getPurchaseById(
            @PathVariable int purchaseId,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                purchaseService.getPurchaseById(purchaseId, user_id)
        );
    }

    // Get Purchase History By Medicine Id
    @GetMapping("/medicine/{medicineId}")
    public ResponseEntity<List<PurchaseResponse>> getPurchasesByMedicineId(
            @PathVariable int medicineId,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                purchaseService.getPurchasesByMedicineId(medicineId, user_id)
        );
    }

}
