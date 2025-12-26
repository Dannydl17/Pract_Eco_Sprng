package com.appEcommerce.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class UserSearchForItemResponse {
    private String name;
    private BigDecimal price;
    private Integer quantity;

}
