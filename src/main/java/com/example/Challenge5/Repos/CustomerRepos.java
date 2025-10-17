package com.example.Challenge5.Repos;

import com.example.Challenge5.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepos extends JpaRepository<Customer, Long> {
}