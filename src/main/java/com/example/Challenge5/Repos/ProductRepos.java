package com.example.Challenge5.Repos;

import com.example.Challenge5.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Product} entities.
 * <p>
 * Provides data access operations for the {@code Product} entity,
 * such as saving, deleting, and finding records in the database.
 * </p>
 *
 * <p>
 * Additional query methods can be defined by following
 * Spring Data JPA naming conventions (e.g., {@code findByName}).
 * </p>
 *
 * @see com.example.Challenge5.Model.Product
 */
public interface ProductRepos extends JpaRepository<Product, Long> {
}
