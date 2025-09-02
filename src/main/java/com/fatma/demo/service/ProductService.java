package com.fatma.demo.service;

import com.fatma.demo.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    // CREATE
    Product createProduct(Product product);

    // READ
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);

    // UPDATE
    Product updateProduct(Long id, Product product);

    // DELETE
    void deleteProduct(Long id);
}
