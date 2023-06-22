package com.example.testprojectusik.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private String description;
    private String manufacturer;
    private String category;
    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Shop shop;
}
