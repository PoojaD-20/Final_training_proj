package com.example.final_proj_training.services;

import java.util.List;

import com.example.final_proj_training.dtos.PrescriptionRequest;
import com.example.final_proj_training.dtos.PrescriptionResponse;

public interface PrescriptionService {

    // Create a new prescription
    PrescriptionResponse createPrescription(PrescriptionRequest request, int user_id);

    // Get all prescriptions of the logged-in user
    List<PrescriptionResponse> getAllPrescriptions(int user_id);

    // Get a particular prescription by id
    PrescriptionResponse getPrescriptionById(int prescription_id, int user_id);

}
