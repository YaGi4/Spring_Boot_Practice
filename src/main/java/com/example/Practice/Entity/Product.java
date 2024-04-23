package com.example.Practice.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products", uniqueConstraints = { @UniqueConstraint(columnNames = {"original_id"})})
public class Product {
    @Id
    @Column(name = "id", nullable = false, length = 30)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_id", nullable = false, length = 30)
    private Long originalId;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "description" , nullable = false)
    private String description;

    @Column(name = "price" , nullable = false, precision = 10)
    private Float price;

    @Column(name = "discount_percentage", precision = 2)
    private Float discountPercentage;

    @Column(name = "rating", length = 5, precision = 2)
    private Float rating;

    @Column(name = "stock", nullable = false, length = 6)
    private Integer stock;

    @Column(name = "brand", length = 35)
    private String brand;

    @Column(name = "category", length = 35)
    private String category;

    @Column(name = "thumbnail", length = 200)
    private String thumbnail;

    @Column(name = "status", length = 15)
    private String status;

    @ToString.Exclude
    @OneToMany(mappedBy = "productId", fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    @JsonManagedReference
    private List<Image> images;

}
