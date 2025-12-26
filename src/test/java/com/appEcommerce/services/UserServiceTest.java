package com.appEcommerce.services;

import com.appEcommerce.data.models.Item;
import com.appEcommerce.dtos.request.UserRegistrationRequest;
import com.appEcommerce.dtos.request.UserSearchForItemRequest;
import com.appEcommerce.dtos.response.UserRegistrationResponse;
import com.appEcommerce.dtos.response.UserSearchForItemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    BigDecimal bigDecimal;

    @BeforeEach
    public void startWithThis(){
        userService.deleteAll();
    }

    @Test
    public void testThatUserCanRegisterTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setFirstName("Ade");
        request.setLastName("Danny");
        request.setEmail("test@test.com");
        request.setPassword("12345");
        request.setPhoneNumber("081234567");
        request.setAddress("8 Isawo Road");

        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());
    }

    @Test
    public void testThatUserCanSearchForItem(){
        UserSearchForItemRequest request = new UserSearchForItemRequest();
        request.setName("Bread");

        UserSearchForItemResponse response = userService.search(request);
        assertNotNull(response);
    }


    @Test
    public void testThatUserCanAddItemToCartTest(){
        UserRegistrationRequest request = new UserRegistrationRequest();
        request.setFirstName("Ade");
        request.setLastName("Danny");
        request.setEmail("test@test.com");
        request.setPassword("12345");
        request.setPhoneNumber("081234567");
        request.setAddress("8 Isawo Road");

        UserRegistrationResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());

        bigDecimal = new BigDecimal("100.00");
        userService.addItemToCart(request.getEmail(), "Water", bigDecimal, 2);
        assertEquals(1, userService.userExist("test@test.com").getCart());

    }
}
