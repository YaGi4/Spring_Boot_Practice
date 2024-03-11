package com.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "images")
public class Images {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_id", referencedColumnName = "original_id")
    private Product productId;

    @Column(name = "image_url")
    private String imageUrl;

}
