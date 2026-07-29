package com.example.final_proj_training.dtos;

import java.time.LocalDate;

public class MedicineRequest {

    private String name;

    private int price;

    private int quantity;

    private LocalDate expiryDate;

    private int category_id;

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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public MedicineRequest() {
		super();
	}

	public MedicineRequest(String name, int price, int quantity, LocalDate expiryDate, int category_id) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.expiryDate = expiryDate;
		this.category_id = category_id;
	}

	@Override
	public String toString() {
		return "MedicineRequest [name=" + name + ", price=" + price + ", quantity=" + quantity + ", expiryDate="
				+ expiryDate + ", category_id=" + category_id + "]";
	}
    
    
   
}
