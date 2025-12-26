package com.appEcommerce.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartResponse {
    private String response;
    private Long itemId;
}
