package com.example.Challenge5.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Represents an order placed by a {@link Customer} for a specific {@link Product}.
 * Each order records the date it was placed and an optional delivery date.
 *
 * <p>This entity is mapped to the {@code orders} table in the database.</p>
 */
@Entity
@Table(name = "orders")
public class Order {

    /** The unique identifier for the order. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** The customer who placed the order. Cannot be null. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    /** The product that was ordered. Cannot be null. */
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    /** The date when the order was placed. Cannot be null. */
    @Column(nullable = false)
    private LocalDate orderDate;

    /** The date when the order is expected to be delivered (optional). */
    private LocalDate deliveryDate;

    /**
     * Default constructor required by JPA.
     */
    public Order() {}

    /**
     * Constructs a new {@code Order} instance with the specified details.
     *
     * @param customer the customer placing the order
     * @param product the product being ordered
     * @param orderDate the date when the order was placed
     * @param deliveryDate the expected delivery date
     */
    public Order(Customer customer, Product product, LocalDate orderDate, LocalDate deliveryDate) {
        this.customer = customer;
        this.product = product;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    /** @return the unique identifier of the order */
    public Long getId() { return id; }

    /** @param id sets the unique identifier of the order */
    public void setId(Long id) { this.id = id; }

    /** @return the customer who placed the order */
    public Customer getCustomer() { return customer; }

    /** @param customer sets the customer who placed the order */
    public void setCustomer(Customer customer) { this.customer = customer; }

    /** @return the product that was ordered */
    public Product getProduct() { return product; }

    /** @param product sets the product that was ordered */
    public void setProduct(Product product) { this.product = product; }

    /** @return the date when the order was placed */
    public LocalDate getOrderDate() { return orderDate; }

    /** @param orderDate sets the date when the order was placed */
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    /** @return the expected delivery date */
    public LocalDate getDeliveryDate() { return deliveryDate; }

    /** @param deliveryDate sets the expected delivery date */
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
}