package com.example.final_proj_training.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.final_proj_training.dtos.PrescriptionRequest;
import com.example.final_proj_training.dtos.PrescriptionResponse;
import com.example.final_proj_training.services.PrescriptionService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    // Create Prescription
    @PostMapping
    public ResponseEntity<PrescriptionResponse> createPrescription(
            @RequestBody PrescriptionRequest request,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                prescriptionService.createPrescription(request, user_id)
        );
    }

    // Get All Prescriptions
    @GetMapping
    public ResponseEntity<List<PrescriptionResponse>> getAllPrescriptions(
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                prescriptionService.getAllPrescriptions(user_id)
        );
    }

    // Get Prescription By Id
    @GetMapping("/{prescription_id}")
    public ResponseEntity<PrescriptionResponse> getPrescriptionById(
            @PathVariable int prescription_id,
            HttpServletRequest httpRequest) {

        int user_id = (Integer) httpRequest.getAttribute("id");

        return ResponseEntity.ok(
                prescriptionService.getPrescriptionById(
                        prescription_id,
                        user_id)
        );
    }

}
