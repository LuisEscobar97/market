package com.example.proyecto2.demo.domain.repository;

import com.example.proyecto2.demo.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScareseProducts(int quantity);
    Optional<Product>getProduct(int productId);
    Product save(Product product);
    void delete(int productId);

}