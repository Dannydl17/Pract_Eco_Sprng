package com.appEcommerce.controllers;

import com.appEcommerce.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/item")
@AllArgsConstructor
public class ItemController {
    public final ItemService itemService;
}
