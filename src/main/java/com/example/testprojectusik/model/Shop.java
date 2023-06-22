package com.example.testprojectusik.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

// Класс Магазин
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address;
    private String phone;
    private String workingHours;
    private double rating;
    @OneToMany(mappedBy = "shop",cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Product> products; // Коллекция товаров в магазине

    public void addProduct(Product product) {
        products.add(product);
        product.setShop(this);
    }
    public void removeProduct(Product product) {
        products.remove(product);
        product.setShop(null);
    }

}