package com.appEcommerce.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddItemToCart {
    private Long CartId;
    private Long itemId;
}
