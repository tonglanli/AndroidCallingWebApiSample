package com.example.androidcallingwebapi.models;

public class Product {
    public int getId() {
        return Id;
    }
 
    public void setId(int id) {
        this.Id = id;
    }
 
    public String getName() {
        return Name;
    }
 
    public void setName(String name) {
        this.Name = name;
    }
 
    public String getDescription() {
        return Description;
    }
 
    public void setDescription(String description) {
        this.Description = description;
    }
 
    public double getPrice() {
        return Price;
    }
 
    public void setPrice(double price) {
        this.Price = price;
    }
 
    private int Id;
    private String Name;
    private String Description;
    private double Price;
 
    public static final String PRODUCT_ID = "Id";
    public static final String PRODUCT_NAME = "Name";
}
