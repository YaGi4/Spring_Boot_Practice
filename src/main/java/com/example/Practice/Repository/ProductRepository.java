package com.example.Practice.Repository;

import com.example.Practice.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<Product> getAll();
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO products (brand, category, description, discount_percentage, original_id, price," +
            " rating, stock, thumbnail, title)" +
            "VALUES (:brand, :category, :description, :discount_percentage, :original_id, :price, :rating, :stock," +
            " :thumbnail, :title)", nativeQuery = true)
    void addProduct(String brand, String category, String description, Float discount_percentage,
                            Long original_id, Float price, Float rating, Integer stock, String thumbnail, String title);
}
