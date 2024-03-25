package com.example.Practice.Repository;

import com.example.Practice.Entity.Image;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query(value = "SELECT * FROM images", nativeQuery = true)
    List<Image> getAll();

    @Query(value = "SELECT * FROM images WHERE original_id = :id", nativeQuery = true)
    List<Image> findAllByProductId(Long id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO images (image_url, original_id) " +
            "VALUES (:Url, :productId)", nativeQuery = true)
    void addImage(String Url, Long productId);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM images", nativeQuery = true)
    void deleteAll();

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM images WHERE image_url = :url", nativeQuery = true)
    void deleteImageByUrl(String url);
}
