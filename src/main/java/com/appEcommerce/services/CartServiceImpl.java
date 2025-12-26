package com.appEcommerce.services;

import com.appEcommerce.data.models.Cart;
import com.appEcommerce.data.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;

    @Override
    public Cart createCart() {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    @Override
    public void deleteAll() {
        cartRepository.deleteAll();
    }
}
