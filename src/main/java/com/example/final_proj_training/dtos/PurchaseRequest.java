package com.example.final_proj_training.dtos;

import java.time.LocalDate;

public class PurchaseRequest {

    private String name;

    private int categoryId;
    private int price;
    private int quantity;
    private LocalDate expiryDate;

    // Default Constructor
    public PurchaseRequest() {
        super();
    }

    // Parameterized Constructor
    public PurchaseRequest(String name, int categoryId, int price, int quantity,
            LocalDate expiryDate) {
        this.name = name;
        this.categoryId = categoryId;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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

    @Override
    public String toString() {
        return "PurchaseRequest [name=" + name + ", categoryId=" + categoryId + ", price=" + price
                + ", quantity=" + quantity + ", expiryDate=" + expiryDate + "]";
    }

}
