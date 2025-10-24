package com.example.Challenge5.DTO;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) for creating a new order.
 * <p>
 * This class encapsulates the necessary information to create an order,
 * including the customer and product identifiers, as well as the order
 * and optional delivery dates. It is typically used by the controller
 * layer to receive data from client requests before mapping to the
 * {@link com.example.Challenge5.Model.Order} entity.
 * </p>
 *
 * <p>
 * The {@code @NotNull} annotations ensure that required fields are
 * validated by the Jakarta Bean Validation API before processing.
 * </p>
 *
 */
public class CreateOrder {

    /**
     * The unique identifier of the customer placing the order.
     * <p>
     * This value must not be {@code null}.
     * </p>
     */
    @NotNull
    private Long customerId;

    /**
     * The unique identifier of the product being ordered.
     * <p>
     * This value must not be {@code null}.
     * </p>
     */
    @NotNull
    private Long productId;

    /**
     * The date when the order is placed.
     * <p>
     * This value must not be {@code null}.
     * </p>
     */
    @NotNull
    private LocalDate orderDate;

    /**
     * The expected delivery date of the order.
     * <p>
     * This field is optional and may be {@code null}.
     * </p>
     */
    private LocalDate deliveryDate;

    /**
     * Returns the ID of the customer who placed the order.
     *
     * @return the customer ID
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the ID of the customer who placed the order.
     *
     * @param customerId the customer ID to set
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * Returns the ID of the product being ordered.
     *
     * @return the product ID
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the ID of the product being ordered.
     *
     * @param productId the product ID to set
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Returns the date when the order was placed.
     *
     * @return the order date
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the date when the order was placed.
     *
     * @param orderDate the order date to set
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Returns the expected delivery date of the order, if provided.
     *
     * @return the delivery date, or {@code null} if not set
     */
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the expected delivery date of the order.
     *
     * @param deliveryDate the delivery date to set
     */
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}
