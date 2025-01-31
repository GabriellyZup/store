package com.ecommerce.store.service;

import com.ecommerce.store.model.Client;
import com.ecommerce.store.model.Order;
import com.ecommerce.store.model.Product;
import com.ecommerce.store.repository.ClientRepository;
import com.ecommerce.store.repository.OrderRepository;
import com.ecommerce.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public Order createOrder(String cpf, List<String> productNames) {
        // Validar cliente
        Client client = clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado: " + cpf));

        // Validar produtos e estoque
        List<Product> products = new ArrayList<>();
        List<String> unavailableProducts = new ArrayList<>();

        for (String productName : productNames) {
            Product product = productRepository.findByName(productName)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + productName));

            if (product.getQuantity() <= 0) {
                unavailableProducts.add(productName);
            } else {
                products.add(product);
            }
        }

        // Se houver produtos indisponíveis, lançar exceção
        if (!unavailableProducts.isEmpty()) {
            throw new RuntimeException("Produtos indisponíveis: " + unavailableProducts);
        }

        // Atualizar estoque dos produtos
        for (Product product : products) {
            product.setQuantity(product.getQuantity() - 1);
            productRepository.save(product);
        }

        // Registrar a compra
        Order order = new Order();
        order.setClient(client);
        order.setProducts(products);
        return orderRepository.save(order);
    }
}