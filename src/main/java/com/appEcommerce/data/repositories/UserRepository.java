package com.appEcommerce.data.repositories;

import com.appEcommerce.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String word);
}
