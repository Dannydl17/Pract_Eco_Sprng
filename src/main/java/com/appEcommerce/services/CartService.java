package com.appEcommerce.services;

import com.appEcommerce.data.models.Cart;

public interface CartService {
    Cart createCart();

    void deleteAll();
}
