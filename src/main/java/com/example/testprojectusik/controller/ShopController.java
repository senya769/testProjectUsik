package com.example.testprojectusik.controller;

import com.example.testprojectusik.model.Product;
import com.example.testprojectusik.model.Shop;
import com.example.testprojectusik.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/")
public class ShopController {
    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("shops")
    public List<Shop> getAll() {
        return shopService.getAll();
    }

    @GetMapping("shop/{id}")
    public Shop getById(@PathVariable long id) {
        return shopService.getById(id);
    }
    @PostMapping("shop")
    public Shop create(@RequestBody Shop shop) {
        return shopService.create(shop);
    }

    @PutMapping("shop/{id}")
    public Shop update(@PathVariable long id, @RequestBody Shop shop) {
        return shopService.update(id, shop);
    }

    @DeleteMapping("shop/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable long id) {
        shopService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("shop/{id}/products")
    public List<Product> getAllProductsByShopId(@PathVariable long id){
        Shop shopFromDB = shopService.getById(id);
        return shopFromDB.getProducts();
    }
    @PostMapping("shop/{id}/product")
    public Shop addProductByShopId(@PathVariable long id,@RequestBody Product product){
        Shop shopFromDB = shopService.getById(id);
        shopFromDB.addProduct(product);
        return shopService.update(id,shopFromDB);
    }
    @PutMapping("shop/{shopId}/product/{productId}")
    public Shop putProductByShopId(@PathVariable long shopId, @RequestBody Product product,
                                     @PathVariable long productId){
        return shopService.putProductByShopId(shopId,productId,product);
    }
    @DeleteMapping("shop/{shopId}/product/{productId}")
    public void removeProductFromShop(@PathVariable Long shopId, @PathVariable Long productId){
        Shop shop = shopService.getById(shopId);
        Product productToRemove = shop.getProducts()
                .stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        shop.removeProduct(productToRemove);
        shopService.update(shopId,shop);
    }
}
