package com.example.Practice.Repository;

import com.example.Practice.Entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    @Query(value = "SELECT * FROM shopping_cart WHERE user_id = :id", nativeQuery = true)
    List<ShoppingCart> getByUserId(Long id);
}
