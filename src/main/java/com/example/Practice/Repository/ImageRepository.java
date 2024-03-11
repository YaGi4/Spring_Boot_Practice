package com.example.Practice.Repository;

import com.example.Practice.Entity.Images;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Images, Long> {
    @Query(value = "SELECT * FROM images", nativeQuery = true)
    List<Images> getAll();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO images (image_url, original_id) " +
            "VALUES (:Url, :productId)", nativeQuery = true)
    void addImage(String Url, Long productId);
}
