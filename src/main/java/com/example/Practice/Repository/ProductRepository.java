package com.example.Practice.Repository;

import com.example.Practice.Entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<Product> getAll(PageRequest pageRequest);
    @Query(value = "SELECT * FROM products WHERE original_id = :id", nativeQuery = true)
    Product getProductByOriginalId(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO products (brand, category, description, discount_percentage, original_id, price," +
            " rating, stock, thumbnail, title, status)" +
            "VALUES (:brand, :category, :description, :discount_percentage, :original_id, :price, :rating, :stock," +
            " :thumbnail, :title, :status)", nativeQuery = true)
    void addProduct(String brand, String category, String description, Float discount_percentage, Long original_id,
                    Float price, Float rating, Integer stock, String thumbnail, String title, String status);


    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE products SET brand = :brand, category = :category, description = :description," +
            " discount_percentage = :discount_percentage, original_id = :original_id, price = :price," +
            " rating = :rating, stock = :stock, thumbnail = :thumbnail, title = :title, status = :status" +
            " WHERE original_id = :original_id", nativeQuery = true)
    void updateProduct(String brand, String category, String description, Float discount_percentage, Long original_id,
                    Float price, Float rating, Integer stock, String thumbnail, String title, String status);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE products SET status = 'not available' ", nativeQuery = true)
        void setNotAvailable();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE products SET status = 'svailable' WHERE original_id = :id", nativeQuery = true)
    void setAvaliableByOriginalId(Long id);

}
