package com.example.testprojectusik.service;

import com.example.testprojectusik.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product create(Product product);
    Product update(Long productId, Product updatedProduct);
    void delete(Long productId);
    List<Product> getAll();
    Product getById(Long productId);
}
