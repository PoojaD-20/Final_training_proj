package com.example.final_proj_training.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PrescriptionItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int req_quantity;
	private int prescription_id;
	private int medicine_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReq_quantity() {
		return req_quantity;
	}
	public void setReq_quantity(int req_quantity) {
		this.req_quantity = req_quantity;
	}
	public int getPrescription_id() {
		return prescription_id;
	}
	public void setPrescription_id(int prescription_id) {
		this.prescription_id = prescription_id;
	}
	public int getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}
	public PrescriptionItem() {
		super();
	}
	public PrescriptionItem(int id, int req_quantity, int prescription_id, int medicine_id) {
		super();
		this.id = id;
		this.req_quantity = req_quantity;
		this.prescription_id = prescription_id;
		this.medicine_id = medicine_id;
	}
	@Override
	public String toString() {
		return "PrescriptionItem [id=" + id + ", req_quantity=" + req_quantity + ", prescription_id=" + prescription_id
				+ ", medicine_id=" + medicine_id + "]";
	}
	
	
}
