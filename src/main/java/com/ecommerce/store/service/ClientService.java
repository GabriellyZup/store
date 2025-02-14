package com.ecommerce.store.service;

import com.ecommerce.store.dto.ClientRequestDTO;
import com.ecommerce.store.dto.ClientResponseDTO;
import com.ecommerce.store.model.Client;
import com.ecommerce.store.repository.ClientRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponseDTO createClient(ClientRequestDTO clientRequestDTO) {
        if (clientRepository.existsByCpf(clientRequestDTO.getCpf())) {
            throw new IllegalArgumentException("CPF ja cadastrado.");
        }
        if (clientRepository.existsByEmail(clientRequestDTO.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
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

    public List<ClientResponseDTO> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(ClientResponseDTO::new)
                .collect(Collectors.toList());
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

    public List<ClientResponseDTO> getClientsByName(String name) {
        List<Client> clients = clientRepository.findByNameContainingIgnoreCase(name);
        if (clients.isEmpty()) {
            throw new IllegalArgumentException("Nenhum cliente encontrado com este nome.");
        }
        return clients.stream()
                .map(ClientResponseDTO::new)
                .collect(Collectors.toList());
    }
}