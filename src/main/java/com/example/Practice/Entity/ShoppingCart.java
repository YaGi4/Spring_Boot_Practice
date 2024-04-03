package com.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable=false, updatable=false)
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", insertable=false, updatable=false)
    private Product productId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "status")
    private String status;

}
