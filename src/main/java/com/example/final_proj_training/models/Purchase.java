package com.example.final_proj_training.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int quantity;
	private LocalDate purchaseDate;
	private int price;
	private int medicine_id;
	private int user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMedicine_id() {
		return medicine_id;
	}
	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Purchase() {
		super();
	}
	public Purchase(int id, int quantity, LocalDate purchaseDate, int price, int medicine_id, int user_id) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.purchaseDate = purchaseDate;
		this.price = price;
		this.medicine_id = medicine_id;
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Purchase [id=" + id + ", quantity=" + quantity + ", purchaseDate=" + purchaseDate + ", price=" + price
				+ ", medicine_id=" + medicine_id + ", user_id=" + user_id + "]";
	}
	
	
	
}
