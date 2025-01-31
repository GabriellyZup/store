package com.ecommerce.store.dto;

import com.ecommerce.store.model.Product;

public class ProductResponseDTO {

    private String name;
    private double price;
    private int quantity;

    public ProductResponseDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}