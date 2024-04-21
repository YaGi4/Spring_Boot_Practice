package com.example.Practice.Service;

import com.example.Practice.Dto.ShoppingCartDto;
import com.example.Practice.Dto.ShoppingCartRequestDto;
import com.example.Practice.Entity.ShoppingCart;
import com.example.Practice.Repository.ProductRepository;
import com.example.Practice.Repository.ShoppingCartRepository;
import com.example.Practice.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingCartService {

    private final Authentication authentication;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private ModelMapper mapper = new ModelMapper();

    public void saveInShoppingCart(ShoppingCartRequestDto shoppingCartRequestDto) {
        final JwtAuthentication jwtAuthentication = authentication.getAuthInfo();

        ShoppingCart shoppingCart = new ShoppingCart(null,
                userRepository.getUserByLogin(jwtAuthentication.getLogin()),
                productRepository.getProductById(shoppingCartRequestDto.getProductId()),
                shoppingCartRequestDto.getQuantity(),
                shoppingCartRequestDto.getDescription());

        shoppingCartRepository.save(shoppingCart);
    }

    public List<ShoppingCartDto> getShoppingCart() {
        final JwtAuthentication jwtAuthentication = authentication.getAuthInfo();
        List<ShoppingCartDto> shoppingCartDto = new ArrayList<>();
        for(ShoppingCart shoppingCart : shoppingCartRepository.getByUserId(jwtAuthentication.getId())) {
            shoppingCartDto.add(mapper.map(shoppingCart, ShoppingCartDto.class));
        }
        return shoppingCartDto;
    }
}
