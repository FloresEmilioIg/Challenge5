package com.example.Challenge5.DTO;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * DTO for creating a new order.
 */
public class CreateOrder {
    @NotNull
    private Long customerId;

    @NotNull
    private Long productId;

    @NotNull
    private LocalDate orderDate;

    private LocalDate deliveryDate;

    // Getters and setters
    public Long getCustomerId() { return customerId; }
    public void setCustomerId(Long customerId) { this.customerId = customerId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public LocalDate getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(LocalDate deliveryDate) { this.deliveryDate = deliveryDate; }
}
