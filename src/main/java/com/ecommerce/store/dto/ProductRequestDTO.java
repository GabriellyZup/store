package com.ecommerce.store.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductRequestDTO {

    @NotBlank(message = "O nome do produto não pode estar vazio.")
    private String name;

    @Min(value = 0, message = "O preço deve ser maior que 0.")
    private double price;

    @Min(value = 0, message = "A quantidade deve ser maior ou igual a 0.")
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}