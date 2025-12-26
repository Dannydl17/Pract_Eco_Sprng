package com.appEcommerce.services;

import com.appEcommerce.data.models.Cart;
import com.appEcommerce.data.models.User;
import com.appEcommerce.dtos.request.UserRegistrationRequest;
import com.appEcommerce.dtos.request.UserSearchForItemRequest;
import com.appEcommerce.dtos.response.UserSearchForItemResponse;
import com.appEcommerce.dtos.response.UserRegistrationResponse;

import java.math.BigDecimal;

public interface UserService {
    UserRegistrationResponse register(UserRegistrationRequest request);
    UserSearchForItemResponse search(UserSearchForItemRequest request);
    User userExist(String email);
//    UserSearchForItemResponse searchForItem(ItemSearchRequest searchRequest);
    Cart addItemToCart(String email, String name, BigDecimal bigDecimal, int quantity);

    void deleteAll();

}
