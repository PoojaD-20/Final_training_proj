package com.example.final_proj_training.dtos;

import java.time.LocalDate;

import com.example.final_proj_training.enums.MedicineStatus;

public class MedicineResponse {
	
	
	private int id;

    private String name;

    private int price;

    private int quantity;

    private LocalDate expiryDate;

    private MedicineStatus status;

    private int category_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public MedicineStatus getStatus() {
		return status;
	}

	public void setStatus(MedicineStatus status) {
		this.status = status;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public MedicineResponse() {
		super();
	}

	public MedicineResponse(int id, String name, int price, int quantity, LocalDate expiryDate, MedicineStatus status,
			int category_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.expiryDate = expiryDate;
		this.status = status;
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "MedicineResponse [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", expiryDate=" + expiryDate + ", status=" + status + ", category_id=" + category_id + "]";
	}
    
    
    

}
