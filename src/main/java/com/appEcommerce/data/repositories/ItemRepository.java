package com.appEcommerce.data.repositories;

import com.appEcommerce.data.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long>{
    Item findItemByName(String searchItem);
}
