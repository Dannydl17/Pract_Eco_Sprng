package com.appEcommerce.services;

import com.appEcommerce.data.models.Item;
import com.appEcommerce.dtos.response.UserSearchForItemResponse;

import java.math.BigDecimal;

public interface ItemService {
    Item createItem(String itemName, BigDecimal bigDecimal, int count);
    Item searchForItem(String searchItem);

    void deleteAll();



}
