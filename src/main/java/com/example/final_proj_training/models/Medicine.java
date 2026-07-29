package com.example.final_proj_training.models;

import java.time.LocalDate;

import com.example.final_proj_training.enums.MedicineStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int price;
	private int quantity;
	private LocalDate expiryDate;
	
	private int category_id;
	private int user_id;
	
	@Enumerated(EnumType.STRING)
    private MedicineStatus status;
	
	@Column(name = "is_deleted", nullable = false)
	private boolean isDeleted = false;

    public void updateStatus() {

        if (expiryDate.isBefore(LocalDate.now())) {
            this.status = MedicineStatus.EXPIRED;
        } else if (quantity <= 10) {
            this.status = MedicineStatus.LOW_STOCK;
        } else {
            this.status = MedicineStatus.AVAILABLE;
        }
    }

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

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public MedicineStatus getStatus() {
		return status;
	}

	public void setStatus(MedicineStatus status) {
		this.status = status;
	}

	public Medicine() {
		super();
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", expiryDate="
				+ expiryDate + ", category_id=" + category_id + ", user_id=" + user_id + ", status=" + status
				+ ", isDeleted=" + isDeleted + "]";
	}

	public Medicine(int id, String name, int price, int quantity, LocalDate expiryDate, int category_id, int user_id,
			MedicineStatus status, boolean isDeleted) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.expiryDate = expiryDate;
		this.category_id = category_id;
		this.user_id = user_id;
		this.status = status;
		this.isDeleted = isDeleted;
	}

	
    
    
}
