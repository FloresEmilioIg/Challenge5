package com.example.Challenge5.Repos;

import com.example.Challenge5.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Order} entities.
 * <p>
 * This interface provides CRUD operations and query methods for the
 * {@code Order} entity by extending the Spring Data {@link JpaRepository}.
 * </p>
 *
 * <p>
 * The repository layer acts as an abstraction over the database,
 * allowing interaction with persistent data without needing
 * boilerplate SQL code.
 * </p>
 *
 * @see com.example.Challenge5.Model.Order
 */
public interface OrderRepos extends JpaRepository<Order, Long> {
}
