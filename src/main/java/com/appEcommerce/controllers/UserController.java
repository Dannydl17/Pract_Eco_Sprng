package com.appEcommerce.controllers;

import com.appEcommerce.dtos.request.UserRegistrationRequest;
import com.appEcommerce.dtos.request.UserSearchForItemRequest;
import com.appEcommerce.dtos.response.UserRegistrationResponse;
import com.appEcommerce.dtos.response.UserSearchForItemResponse;
import com.appEcommerce.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationRequest registrationRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userService.register(registrationRequest));
    }

    @PostMapping("/search")
    public ResponseEntity<UserSearchForItemResponse> searchItem(@RequestBody UserSearchForItemRequest request){
        UserSearchForItemResponse response = userService.search(request);
        return ResponseEntity.ok(response);
    }


}
