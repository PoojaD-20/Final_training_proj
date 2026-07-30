package com.example.final_proj_training.serv_impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.final_proj_training.dtos.PrescriptionItemRequest;
import com.example.final_proj_training.dtos.PrescriptionItemResponse;
import com.example.final_proj_training.dtos.PrescriptionRequest;
import com.example.final_proj_training.dtos.PrescriptionResponse;
import com.example.final_proj_training.exceptions.InsufficientStockException;
import com.example.final_proj_training.exceptions.ResourceNotFoundException;
import com.example.final_proj_training.models.Medicine;
import com.example.final_proj_training.models.Prescription;
import com.example.final_proj_training.models.PrescriptionItem;
import com.example.final_proj_training.repositories.MedicineRepository;
import com.example.final_proj_training.repositories.PrescriptionItemRepository;
import com.example.final_proj_training.repositories.PrescriptionRepository;
import com.example.final_proj_training.services.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private PrescriptionItemRepository prescriptionItemRepository;

    @Autowired
    private MedicineRepository medicineRepository;


        @Override
    @Transactional
    public PrescriptionResponse createPrescription(PrescriptionRequest request, int user_id) {

        // Create Prescription
        Prescription prescription = new Prescription();
        prescription.setUser_id(user_id);

        Prescription savedPrescription =
                prescriptionRepository.save(prescription);

        List<PrescriptionItemResponse> itemResponses =
                new ArrayList<>();

        // Process every medicine
        for (PrescriptionItemRequest itemRequest : request.getMedicines()) {

            // Check medicine exists for logged-in user
            Medicine medicine = medicineRepository
                    .findByIdAndUserId(itemRequest.getMedicine_id(), user_id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Medicine not found"));

            // Check sufficient stock
            if (medicine.getQuantity() < itemRequest.getReq_quantity()) {

                throw new InsufficientStockException(
                        "Insufficient stock for medicine : "
                                + medicine.getName());
            }

            // Reduce stock
            medicine.setQuantity(
                    medicine.getQuantity()
                            - itemRequest.getReq_quantity());

            // Update medicine status
            medicine.updateStatus();

            // Save updated medicine
            medicineRepository.save(medicine);

            // Create PrescriptionItem
            PrescriptionItem prescriptionItem =
                    new PrescriptionItem();

            prescriptionItem.setPrescription_id(
                    savedPrescription.getId());

            prescriptionItem.setMedicine_id(
                    medicine.getId());

            prescriptionItem.setReq_quantity(
                    itemRequest.getReq_quantity());

            prescriptionItemRepository.save(
                    prescriptionItem);

            // Response Item
            PrescriptionItemResponse response =
                    new PrescriptionItemResponse();

            response.setMedicine_id(medicine.getId());
            response.setMedicine_name(medicine.getName());
            response.setReq_quantity(itemRequest.getReq_quantity());

            itemResponses.add(response);

        }

        PrescriptionResponse response =
                new PrescriptionResponse();

        response.setPrescription_id(savedPrescription.getId());
        response.setMedicines(itemResponses);

        return response;

    }


    @Override
public List<PrescriptionResponse> getAllPrescriptions(int user_id) {

    List<Prescription> prescriptions =
            prescriptionRepository.getAllPrescriptionsByUserId(user_id);

    List<PrescriptionResponse> prescriptionResponses =
            new ArrayList<>();

    for (Prescription prescription : prescriptions) {

        List<PrescriptionItem> prescriptionItems =
                prescriptionItemRepository.getPrescriptionItemsByPrescriptionId(
                        prescription.getId());

        List<PrescriptionItemResponse> itemResponses =
                new ArrayList<>();

        for (PrescriptionItem item : prescriptionItems) {

            Medicine medicine = medicineRepository
                    .findByIdAndUserId(item.getMedicine_id(), user_id)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Medicine not found"));

            PrescriptionItemResponse itemResponse =
                    new PrescriptionItemResponse();

            itemResponse.setMedicine_id(medicine.getId());
            itemResponse.setMedicine_name(medicine.getName());
            itemResponse.setReq_quantity(item.getReq_quantity());

            itemResponses.add(itemResponse);
        }

        PrescriptionResponse response =
                new PrescriptionResponse();

        response.setPrescription_id(prescription.getId());
        response.setMedicines(itemResponses);

        prescriptionResponses.add(response);
    }

    return prescriptionResponses;
}

@Override
public PrescriptionResponse getPrescriptionById(int prescription_id, int user_id) {

    Prescription prescription = prescriptionRepository
            .getPrescriptionById(prescription_id, user_id)
            .orElseThrow(() ->
                    new ResourceNotFoundException("Prescription not found"));

    List<PrescriptionItem> prescriptionItems =
            prescriptionItemRepository.getPrescriptionItemsByPrescriptionId(
                    prescription.getId());

    List<PrescriptionItemResponse> itemResponses =
            new ArrayList<>();

    for (PrescriptionItem item : prescriptionItems) {

        Medicine medicine = medicineRepository
                .findByIdAndUserId(item.getMedicine_id(), user_id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Medicine not found"));

        PrescriptionItemResponse itemResponse =
                new PrescriptionItemResponse();

        itemResponse.setMedicine_id(medicine.getId());
        itemResponse.setMedicine_name(medicine.getName());
        itemResponse.setReq_quantity(item.getReq_quantity());

        itemResponses.add(itemResponse);
    }

    PrescriptionResponse response = new PrescriptionResponse();

    response.setPrescription_id(prescription.getId());
    response.setMedicines(itemResponses);

    return response;
}

}