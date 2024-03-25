package com.example.Practice.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@Table(name = "products", uniqueConstraints = { @UniqueConstraint(columnNames = {"original_id"})})
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_id")
    private Long originalId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "discount_percentage")
    private Float discountPercentage;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "brand")
    private String brand;

    @Column(name = "category")
    private String category;

    @Column(name = "thumbnail")
    private String thumbnail;

    @Column(name = "status")
    private String status;

    @ToString.Exclude
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Image> images;
}
