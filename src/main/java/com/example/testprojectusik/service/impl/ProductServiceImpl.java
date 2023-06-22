package com.example.testprojectusik.service.impl;

import com.example.testprojectusik.model.Product;
import com.example.testprojectusik.repo.ProductRepo;
import com.example.testprojectusik.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    public final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }


    @Override
    public Product create(Product product) {
       return productRepo.save(product);
    }

    @Override
    public Product update(Long productId, Product updatedProduct) {
        Product existingProduct = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        // Обновление свойств товара
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setManufacturer(updatedProduct.getManufacturer());
        existingProduct.setCategory(updatedProduct.getCategory());

        return productRepo.save(existingProduct);
    }

    @Override
    public void delete(Long productId) {
        Product existingProduct = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        productRepo.delete(existingProduct);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(Long productId) {
        return productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));
    }
}
