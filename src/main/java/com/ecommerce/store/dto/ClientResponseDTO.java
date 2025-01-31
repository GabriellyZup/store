package com.ecommerce.store.dto;

import com.ecommerce.store.model.Client;

public class ClientResponseDTO {

    private String name;
    private String cpf;
    private String email;

    public ClientResponseDTO(Client client) {
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.email = client.getEmail();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}