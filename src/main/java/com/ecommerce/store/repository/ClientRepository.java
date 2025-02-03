package com.ecommerce.store.repository;

import com.ecommerce.store.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByCpf(String cpf);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);

    List<Client> findByNameContainingIgnoreCase(String name);
}