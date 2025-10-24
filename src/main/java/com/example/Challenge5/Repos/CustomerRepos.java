package com.example.Challenge5.Repos;

import com.example.Challenge5.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Customer} entities.
 * <p>
 * This interface provides basic CRUD and pagination functionality
 * for the {@code Customer} entity through Spring Data JPA.
 * </p>
 *
 * <p>
 * Developers can extend this interface with custom query methods
 * (following Spring Data's naming conventions) as needed.
 * </p>
 *
 * @see com.example.Challenge5.Model.Customer
 */
public interface CustomerRepos extends JpaRepository<Customer, Long> {
}
