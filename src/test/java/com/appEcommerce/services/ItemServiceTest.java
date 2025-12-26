package com.appEcommerce.services;

import com.appEcommerce.data.models.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ItemServiceTest {
    @Autowired
    private ItemService itemService;
    private SecureRandom randomNumber;
    BigDecimal bigDecimal;
    @BeforeEach
    public void startWithThis(){
        itemService.deleteAll();
    }

    @Test
    public void testThatItemCanBeCreated(){
        String itemName = "Bread";
        bigDecimal= new BigDecimal("50.00");
        System.out.println(bigDecimal);
        int count = 3;
        Item item = itemService.createItem(itemName, bigDecimal, count);
        assertEquals("Bread", item.getName());
    }

    @Test
    public void testThatItemCanBeCreatedTwice(){
        String itemName = "Bread";
        bigDecimal= new BigDecimal("50.00");
        System.out.println(bigDecimal);
        int count = 3;
        Item item = itemService.createItem(itemName, bigDecimal, count);
        assertEquals("Bread", item.getName());

        itemName = "Water";
        bigDecimal= new BigDecimal("150.00");
        System.out.println(bigDecimal);
        count = 2;
        item = itemService.createItem(itemName, bigDecimal, count);
        assertEquals("Water", item.getName());

    }

    @Test
    public void testThatItemCanBeSearchForItemTest(){
        String itemName = "Bread";
        bigDecimal= new BigDecimal("50.00");
        int count = 3;
        Item item = itemService.createItem(itemName, bigDecimal, count);
        assertEquals("Bread", item.getName());

        itemName = "Water";
        bigDecimal= new BigDecimal("150.00");
        count = 2;
        item = itemService.createItem(itemName, bigDecimal, count);
        assertEquals("Water", item.getName());

        itemName = "Rice";
        bigDecimal= new BigDecimal("250.00");
        count = 1;
        item = itemService.createItem(itemName, bigDecimal, count);
        assertEquals("Rice", item.getName());

        String searchItem = "Rice";

        Item foundItem = itemService.searchForItem(searchItem);
        assertEquals("Rice", foundItem.getName());
    }

    @Test
    public void testThatItemCanBeCreatedWhenNotFoundTest(){
        String itemName = "Bread";
        bigDecimal= new BigDecimal("50.00");
        int count = 3;
        Item item = itemService.createItem(itemName, bigDecimal, count);
        assertEquals("Bread", item.getName());

        itemName = "Water";
        bigDecimal= new BigDecimal("150.00");
        count = 2;
        item = itemService.createItem(itemName, bigDecimal, count);
        assertEquals("Water", item.getName());

        itemName = "Rice";
        bigDecimal= new BigDecimal("250.00");
        count = 1;
        item = itemService.createItem(itemName, bigDecimal, count);
        assertEquals("Rice", item.getName());

        String searchItem = "Rice";

        Item foundItem = itemService.searchForItem(searchItem);
        assertEquals("Rice", foundItem.getName());

        searchItem = "Beans";

        Item created = itemService.searchForItem(searchItem);
        assertEquals("Beans", created.getName());
    }



}
