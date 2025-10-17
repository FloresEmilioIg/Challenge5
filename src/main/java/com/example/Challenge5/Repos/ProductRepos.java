package com.example.Challenge5.Repos;

import com.example.Challenge5.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepos extends JpaRepository<Product, Long> {

}
