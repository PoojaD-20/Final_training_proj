package com.example.final_proj_training.dtos;

public class PrescriptionItemResponse {

	private int medicine_id;
    private String medicine_name;
    private int req_quantity;

    // Default Constructor
    public PrescriptionItemResponse() {
        super();
    }

    // Parameterized Constructor
    public PrescriptionItemResponse(int medicine_id,
                                    String medicine_name,
                                    int req_quantity) {
        super();
        this.medicine_id = medicine_id;
        this.medicine_name = medicine_name;
        this.req_quantity = req_quantity;
    }

    public int getMedicine_id() {
        return medicine_id;
    }

    public void setMedicine_id(int medicine_id) {
        this.medicine_id = medicine_id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public int getReq_quantity() {
        return req_quantity;
    }

    public void setReq_quantity(int req_quantity) {
        this.req_quantity = req_quantity;
    }

    @Override
    public String toString() {
        return "PrescriptionItemResponse [medicine_id=" + medicine_id
                + ", medicine_name=" + medicine_name
                + ", req_quantity=" + req_quantity + "]";
    }
    
}
