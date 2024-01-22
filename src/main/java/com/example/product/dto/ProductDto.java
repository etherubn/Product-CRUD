package com.example.product.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductDto {
    private long id;
    @NotNull(message = "Price must contain a value")
    @Positive(message = "Price must be positive")
    private double price;

    @NotNull(message = "discount must contain a value")
    @Positive(message = "discount must be positive")
    private double discount;

    @NotNull(message = "finalPrice must contain a value")
    @Positive(message = "finalPrice must be positive")
    private double finalPrice;
    private String description;

    @NotNull(message = "weight must contain a value")
    @Positive(message = "weight must be positive")
    private double weight;

    @NotNull(message = "height must contain a value")
    @Positive(message = "height must be positive")
    private double height;

    @NotNull(message = "width must contain a value")
    @Positive(message = "width must be positive")
    private double width;
    @NotNull(message = "length must contain a value")
    @Positive(message = "length must be positive")
    private double length;

    @NotNull(message = "initialStock must contain a value")
    @Positive(message = "initialStock must be positive")
    private int initialStock;

    @NotNull(message = "soldUnits must contain a value")
    @Positive(message = "soldUnits must be positive")
    private int soldUnits;

    @NotNull(message = "currentStock must contain a value")
    @Positive(message = "currentStock must be positive")
    private int currentStock;

    public ProductDto() {
    }

    public ProductDto(long id, double price, double discount, double finalPrice, String description, double weight, double height, double width, double length, int initialStock, int soldUnits, int currentStock) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.description = description;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.length = length;
        this.initialStock = initialStock;
        this.soldUnits = soldUnits;
        this.currentStock = currentStock;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getInitialStock() {
        return initialStock;
    }

    public void setInitialStock(int initialStock) {
        this.initialStock = initialStock;
    }

    public int getSoldUnits() {
        return soldUnits;
    }

    public void setSoldUnits(int soldUnits) {
        this.soldUnits = soldUnits;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }
}
