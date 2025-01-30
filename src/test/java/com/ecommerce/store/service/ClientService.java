package com.ecommerce.store.service;

import com.ecommerce.store.dto.ClientRequestDTO;
import com.ecommerce.store.dto.ClientResponseDTO;
import com.ecommerce.store.model.Client;
import com.ecommerce.store.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        if (clientRepository.existsByCpf(clientRequestDTO.getCpf())) {
            throw new IllegalArgumentException("Já existe um cliente com este CPF.");
        }
        if (clientRepository.existsByEmail(clientRequestDTO.getEmail())) {
            throw new IllegalArgumentException("Já existe um cliente com este email.");
        }

        Client client = new Client();
        client.setName(clientRequestDTO.getName());
        client.setCpf(clientRequestDTO.getCpf());
        client.setEmail(clientRequestDTO.getEmail());

        Client savedClient = clientRepository.save(client);
        return new ClientResponseDTO(savedClient);
    }

    public ClientResponseDTO getClientByCpf(String cpf) {
        Client client = clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        return new ClientResponseDTO(client);
    }

    public ClientResponseDTO updateClient(String cpf, ClientRequestDTO clientRequestDTO) {
        Client client = clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        client.setName(clientRequestDTO.getName());
        client.setEmail(clientRequestDTO.getEmail());

        Client updatedClient = clientRepository.save(client);
        return new ClientResponseDTO(updatedClient);
    }

    public void deleteClient(String cpf) {
        Client client = clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        clientRepository.delete(client);
    }
}