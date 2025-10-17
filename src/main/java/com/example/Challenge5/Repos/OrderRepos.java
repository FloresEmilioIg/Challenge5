package com.example.Challenge5.Repos;

import com.example.Challenge5.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepos extends JpaRepository<Order, Long> {
}
