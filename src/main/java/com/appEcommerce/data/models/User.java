package com.appEcommerce.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    @OneToOne(fetch = EAGER, cascade = {CascadeType.MERGE})
    private Cart cart = new Cart();
}
