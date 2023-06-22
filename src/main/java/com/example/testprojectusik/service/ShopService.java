package com.example.testprojectusik.service;

import com.example.testprojectusik.model.Product;
import com.example.testprojectusik.model.Shop;

import java.util.List;

public interface ShopService {
    Shop create(Shop shop);
    Shop update(Long shopId, Shop updatedShop);
    void delete(Long shopId);
    List<Shop> getAll();
    Shop getById(Long shopId);
   Shop putProductByShopId(long shopId, long productId, Product updatedProduct);
}
