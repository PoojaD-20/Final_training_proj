package com.example.final_proj_training.dtos;

public class PrescriptionItemRequest {

	
    private int medicine_id;
    private int req_quantity;

    // Default Constructor
    public PrescriptionItemRequest() {
        super();
    }

    // Parameterized Constructor
    public PrescriptionItemRequest(int medicine_id, int req_quantity) {
        super();
        this.medicine_id = medicine_id;
        this.req_quantity = req_quantity;
    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public int getReq_quantity() {
        return req_quantity;
    }

    public void setReq_quantity(int req_quantity) {
        this.req_quantity = req_quantity;
    }

    @Override
    public String toString() {
        return "PrescriptionItemRequest [medicine_id=" + medicine_id
                + ", req_quantity=" + req_quantity + "]";
    }
    
}
