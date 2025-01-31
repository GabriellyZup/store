package com.ecommerce.store.service;

import com.ecommerce.store.dto.ProductRequestDTO;
import com.ecommerce.store.dto.ProductResponseDTO;
import com.ecommerce.store.model.Product;
import com.ecommerce.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        if (productRepository.existsByName(productRequestDTO.getName())) {
            throw new IllegalArgumentException("Já existe um produto com este nome.");
        }

        Product product = new Product();
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantity(productRequestDTO.getQuantity());

        Product savedProduct = productRepository.save(product);
        return new ProductResponseDTO(savedProduct);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
        productRepository.deleteById(id);
    }
}