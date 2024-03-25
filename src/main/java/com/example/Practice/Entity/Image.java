package com.example.Practice.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "images")
public class Image {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_id", referencedColumnName = "original_id")
    @JsonBackReference
    private Product productId;

    @Column(name = "image_url")
    private String imageUrl;

}
