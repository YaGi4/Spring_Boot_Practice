package com.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "shopping_cart")
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User userId;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "description", length = 100)
    private String description;
}
