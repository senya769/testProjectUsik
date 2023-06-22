package com.example.testprojectusik.service.impl;

import com.example.testprojectusik.model.Product;
import com.example.testprojectusik.model.Shop;
import com.example.testprojectusik.repo.ProductRepo;
import com.example.testprojectusik.repo.ShopRepo;
import com.example.testprojectusik.service.ShopService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopServiceImpl implements ShopService {
    private final ShopRepo shopRepo;
    private final ProductRepo productRepo;


    public ShopServiceImpl(ShopRepo shopRepo, ProductRepo productRepo) {
        this.shopRepo = shopRepo;
        this.productRepo = productRepo;
    }

    @Override
    public Shop create(Shop shop) {
        return shopRepo.save(shop);
    }

    @Override
    public Shop update(Long shopId, Shop updatedShop) {
        Shop existingShop = shopRepo.findById(shopId)
                .orElseThrow(() -> new RuntimeException("Shop not found with id: " + shopId));

        // Обновление свойств товара
        existingShop.setName(updatedShop.getName());
        existingShop.setAddress(updatedShop.getAddress());
        existingShop.setPhone(updatedShop.getPhone());
        existingShop.setRating(updatedShop.getRating());
        existingShop.setWorkingHours(updatedShop.getWorkingHours());

        return shopRepo.save(existingShop);
    }

    @Override
    public void delete(Long shopId) {
        Shop existingShop = shopRepo.findById(shopId)
                .orElseThrow(() -> new RuntimeException("Shop not found with id: " + shopId));

        shopRepo.delete(existingShop);
    }

    @Override
    public List<Shop> getAll() {
        return shopRepo.findAll();
    }

    @Override
    public Shop getById(Long shopId) {
        return shopRepo.findById(shopId).orElseThrow(() -> new RuntimeException("Shop not found with id: " + shopId));
    }

    public Shop putProductByShopId(long shopId, long productId, Product updatedProduct) {
        Shop shop = shopRepo.findById(shopId)
                .orElseThrow(() -> new RuntimeException("Shop not found with id: " + shopId));

        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        // Обновление свойств продукта
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        product.setManufacturer(updatedProduct.getManufacturer());
        product.setCategory(updatedProduct.getCategory());

        // Добавление/обновление продукта в магазине
        shop.addProduct(product);
        return shopRepo.save(shop);
    }
}
