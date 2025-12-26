package com.appEcommerce.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    private List<Item> itemsForCart = new ArrayList<>();
}
