package com.appEcommerce.services;

import com.appEcommerce.data.models.Item;
import com.appEcommerce.data.repositories.ItemRepository;
import com.appEcommerce.dtos.response.UserSearchForItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;


    @Override
    public Item createItem(String itemName, BigDecimal bigDecimal, int count) {
        Item item = new Item();
        item.setName(itemName);
        item.setPrice(bigDecimal);
        item.setQuantity(count);
        return itemRepository.save(item);
    }

    @Override
    public Item searchForItem(String searchItem) {
        Item item = itemRepository.findItemByName(searchItem);
        String n = item.getName();
        if (!n.equals(searchItem)){
            createItem(searchItem, new BigDecimal("00.00"), 0);
            item = itemRepository.findItemByName(searchItem);
            return item;
        }
        else {
            return item;
        }
    }


    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
