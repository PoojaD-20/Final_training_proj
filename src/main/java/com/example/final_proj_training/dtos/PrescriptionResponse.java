package com.example.final_proj_training.dtos;

import java.util.List;

public class PrescriptionResponse {

	private int prescription_id;
    private List<PrescriptionItemResponse> medicines;

    // Default Constructor
    public PrescriptionResponse() {
        super();
    }

    // Parameterized Constructor
    public PrescriptionResponse(int prescription_id,
                                List<PrescriptionItemResponse> medicines) {
        super();
        this.prescription_id = prescription_id;
        this.medicines = medicines;
    }

    public int getPrescription_id() {
        return prescription_id;
    }

    public void setPrescription_id(int prescription_id) {
        this.prescription_id = prescription_id;
    }

    public List<PrescriptionItemResponse> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<PrescriptionItemResponse> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "PrescriptionResponse [prescription_id=" + prescription_id
                + ", medicines=" + medicines + "]";
    }
    
}
