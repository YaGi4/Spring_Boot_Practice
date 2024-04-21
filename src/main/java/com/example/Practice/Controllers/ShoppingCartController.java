package com.example.Practice.Controllers;

import com.example.Practice.Dto.ShoppingCartDto;
import com.example.Practice.Dto.ShoppingCartRequestDto;
import com.example.Practice.Service.ShoppingCartService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCart")
@RequiredArgsConstructor
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public void addProductToShoppingCart(@RequestBody @Valid ShoppingCartRequestDto shoppingCartRequestDto) {
        shoppingCartService.saveInShoppingCart(shoppingCartRequestDto);
    }

    @GetMapping("/getAll")
    public List<ShoppingCartDto> getShoppingCart() {
        return shoppingCartService.getShoppingCart();
    }
}
