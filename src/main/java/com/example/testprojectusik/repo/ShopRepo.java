package com.example.testprojectusik.repo;

import com.example.testprojectusik.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepo extends JpaRepository<Shop, Long> {
}
