package com.ecommerce.store.dto;

//import com.ecommerce.store.util.CpfValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class ClientRequestDTO {

    @NotBlank(message = "O nome não pode estar vazio.")
    private String name;

    @NotBlank(message = "O CPF não pode estar vazio.")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter exatamente 11 dígitos.")
    private String cpf;

    @NotBlank(message = "O email não pode estar vazio.")
    @Email(message = "Formato de email inválido.")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
//        if (!CpfValidator.isValidCPF(cpf)) {
//            throw new IllegalArgumentException("CPF inválido.");
//        }
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}