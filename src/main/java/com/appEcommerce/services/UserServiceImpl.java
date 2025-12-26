package com.appEcommerce.services;

import com.appEcommerce.data.models.Cart;
import com.appEcommerce.data.models.Item;
import com.appEcommerce.data.models.User;
import com.appEcommerce.data.repositories.UserRepository;
import com.appEcommerce.dtos.request.UserRegistrationRequest;
import com.appEcommerce.dtos.request.UserSearchForItemRequest;
import com.appEcommerce.dtos.response.UserRegistrationResponse;
import com.appEcommerce.dtos.response.UserSearchForItemResponse;
import com.appEcommerce.exceptions.UserFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private CartService cartService;
    private ItemService itemService;

    @Override
    public UserRegistrationResponse register(UserRegistrationRequest request) {
        User user = userExist(request.getEmail());
        if (user != null && user.getEmail() == request.getEmail()){
            throw new UserFoundException(" user already exist");
        }
        user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAddress(request.getAddress());
        Cart cart = cartService.createCart();
        user.setCart(cart);

        User saveUser = userRepository.save(user);
        UserRegistrationResponse response = new UserRegistrationResponse();
        response.setId(saveUser.getId());
        return response;
    }

    @Override
    public UserSearchForItemResponse search(UserSearchForItemRequest request) {
        String name = request.getName();
        Item item = itemService.searchForItem(name);
        UserSearchForItemResponse response = new UserSearchForItemResponse();
        response.setName(item.getName());
        response.setPrice(item.getPrice());
        response.setQuantity(item.getQuantity());
        return response;
    }

    @Override
    public User userExist(String word) {
        User user = userRepository.findUserByEmail(word);
        return user;
    }


    @Override
    public Cart addItemToCart(String email, String name, BigDecimal bigDecimal, int quantity) {
        User user = userRepository.findUserByEmail(email);
        Cart cart = user.getCart();
        return cart;
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }



}
