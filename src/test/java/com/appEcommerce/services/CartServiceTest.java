package com.appEcommerce.services;

import com.appEcommerce.data.models.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CartServiceTest {
    @Autowired
    private CartService cartService;

    @BeforeEach
    public void startWithThis(){
        cartService.deleteAll();
    }

    @Test
    public void testThatCanCreateCart(){
        Cart cart = cartService.createCart();
        assertNotNull(cart);
    }

    @Test
    public void testThatItemCanBeAddedToCartTest(){

    }
}
