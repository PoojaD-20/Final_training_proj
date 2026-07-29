package com.example.final_proj_training.dtos;

import java.time.LocalDate;

public class PurchaseResponse {

    private int id;
    private String medicineName;
    private int quantity;
    private int price;
    private LocalDate purchaseDate;

    // Default Constructor
    public PurchaseResponse() {
        super();
    }

    // Parameterized Constructor
    public PurchaseResponse(int id, String medicineName, int quantity, int price, LocalDate purchaseDate) {
        super();
        this.id = id;
        this.medicineName = medicineName;
        this.quantity = quantity;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for medicineName
    public String getMedicineName() {
        return medicineName;
    }

    // Setter for medicineName
    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Getter for price
    public int getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(int price) {
        this.price = price;
    }

    // Getter for purchaseDate
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    // Setter for purchaseDate
    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "PurchaseResponse [id=" + id + ", medicineName=" + medicineName
                + ", quantity=" + quantity + ", price=" + price
                + ", purchaseDate=" + purchaseDate + "]";
    }

}
