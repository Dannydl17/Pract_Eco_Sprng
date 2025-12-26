package com.appEcommerce.controllers;

import com.appEcommerce.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;
}
