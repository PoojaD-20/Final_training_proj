package com.example.final_proj_training.dtos;

import java.util.List;

public class PrescriptionRequest {

    private List<PrescriptionItemRequest> medicines;

    // Default Constructor
    public PrescriptionRequest() {
        super();
    }

    // Parameterized Constructor
    public PrescriptionRequest(List<PrescriptionItemRequest> medicines) {
        super();
        this.medicines = medicines;
    }

    public List<PrescriptionItemRequest> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<PrescriptionItemRequest> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "PrescriptionRequest [medicines=" + medicines + "]";
    }
    
}
