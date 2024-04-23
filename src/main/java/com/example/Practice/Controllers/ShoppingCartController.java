package com.example.Practice.Controllers;

import com.example.Practice.Dto.ShoppingCartDto;
import com.example.Practice.Dto.ShoppingCartRequestDto;
import com.example.Practice.Service.ShoppingCart;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCart shoppingCart;

    @PostMapping("/add")
    public void addProductToShoppingCart(@RequestBody @Valid ShoppingCartRequestDto shoppingCartRequestDto) {
        shoppingCart.saveInShoppingCart(shoppingCartRequestDto);
    }

    @GetMapping("/getAll")
    public List<ShoppingCartDto> getShoppingCart() {
        return shoppingCart.getShoppingCart();
    }
}
