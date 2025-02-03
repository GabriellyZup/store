package com.ecommerce.store.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductRequestDTO {

    @NotBlank(message = "O nome do produto não pode estar vazio.")
    private String name;

    @DecimalMin(value = "0.01", message = "O preço deve ser maior que 0.")
    @Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 2 casas decimais.")
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