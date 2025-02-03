package com.ecommerce.store.controller;

import com.ecommerce.store.dto.ClientRequestDTO;
import com.ecommerce.store.dto.ClientResponseDTO;
import com.ecommerce.store.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@Valid @RequestBody ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO savedClient = clientService.createClient(clientRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> getClientByCpf(@PathVariable String cpf) {
        ClientResponseDTO client = clientService.getClientByCpf(cpf);
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAllClients() {
        List<ClientResponseDTO> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable String cpf, @Valid @RequestBody ClientRequestDTO clientRequestDTO) {
        ClientResponseDTO updatedClient = clientService.updateClient(cpf, clientRequestDTO);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<Void> deleteClient(@PathVariable String cpf) {
        clientService.deleteClient(cpf);
        return ResponseEntity.noContent().build();
    }
}