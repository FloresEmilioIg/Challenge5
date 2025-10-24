package com.example.Challenge5.Visual;

import com.example.Challenge5.Model.Order;
import com.example.Challenge5.Model.Customer;
import com.example.Challenge5.Model.Product;
import com.example.Challenge5.Repos.OrderRepos;
import com.example.Challenge5.Repos.CustomerRepos;
import com.example.Challenge5.Repos.ProductRepos;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service layer for managing business logic related to {@link Order} entities.
 * <p>
 * This class provides high-level operations for creating, retrieving, updating,
 * and deleting orders. It acts as an intermediary between the controller layer
 * and the data repositories ({@link OrderRepos}, {@link CustomerRepos}, and
 * {@link ProductRepos}), ensuring that all interactions with persistent data
 * follow proper validation and business rules.
 * </p>
 *
 * <p>
 * Annotated with {@link Service} to indicate that it is a Spring-managed
 * component responsible for encapsulating business logic.
 * </p>
 *
 */
@Service
public class OrderService {

    /** Repository for accessing and managing {@link Order} entities. */
    private final OrderRepos orderRepository;

    /** Repository for accessing and managing {@link Customer} entities. */
    private final CustomerRepos customerRepository;

    /** Repository for accessing and managing {@link Product} entities. */
    private final ProductRepos productRepository;

    /**
     * Constructs a new {@code OrderService} with the required repository dependencies.
     *
     * @param orderRepository    the repository used to manage orders
     * @param customerRepository the repository used to manage customers
     * @param productRepository  the repository used to manage products
     */
    public OrderService(OrderRepos orderRepository,
                        CustomerRepos customerRepository,
                        ProductRepos productRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    /**
     * Creates and persists a new {@link Order} in the database.
     *
     * @param order the {@link Order} object containing order details to save
     * @return the newly created {@link Order} entity
     */
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    /**
     * Retrieves all existing {@link Order} records from the database.
     *
     * @return a list of all {@link Order} entities
     */
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Retrieves an {@link Order} by its unique identifier.
     *
     * @param id the ID of the order to retrieve
     * @return the {@link Order} entity corresponding to the given ID
     * @throws RuntimeException if no order exists with the given ID
     */
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    /**
     * Updates an existing {@link Order} with new details.
     * <p>
     * This method ensures that both the customer and product referenced in the
     * updated order exist before applying changes. If either is missing, a
     * {@link RuntimeException} is thrown.
     * </p>
     *
     * @param id            the ID of the order to update
     * @param orderDetails  an {@link Order} object containing updated data
     * @return the updated {@link Order} entity
     * @throws RuntimeException if the order, customer, or product does not exist
     */
    public Order updateOrder(Long id, Order orderDetails) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));

        // Validate that client & product exist
        Customer customer = customerRepository.findById(orderDetails.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Product product = productRepository.findById(orderDetails.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Update fields
        existingOrder.setCustomer(customer);
        existingOrder.setProduct(product);
        existingOrder.setOrderDate(orderDetails.getOrderDate());
        existingOrder.setDeliveryDate(orderDetails.getDeliveryDate());

        return orderRepository.save(existingOrder);
    }

    /**
     * Deletes an {@link Order} from the database by its unique identifier.
     *
     * @param id the ID of the order to delete
     * @throws RuntimeException if the order does not exist
     */
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(id);
    }
}