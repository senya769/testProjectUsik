package com.example.testprojectusik.repo;

import com.example.testprojectusik.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
