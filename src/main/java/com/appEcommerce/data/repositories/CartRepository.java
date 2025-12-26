package com.appEcommerce.data.repositories;

import com.appEcommerce.data.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
